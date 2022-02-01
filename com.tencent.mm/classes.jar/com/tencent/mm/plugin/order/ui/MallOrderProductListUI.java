package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI
  extends WalletBaseUI
{
  private ListView bEw;
  private String nSt;
  private List<ProductSectionItem> uQh;
  private String wXY;
  private BaseAdapter wyr;
  
  public MallOrderProductListUI()
  {
    AppMethodBeat.i(66750);
    this.uQh = new ArrayList();
    this.wXY = "";
    this.nSt = "";
    AppMethodBeat.o(66750);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_order_product_list;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(66752);
    setMMTitle(a.i.mall_order_products_list_ui_title);
    Bundle localBundle = getInput();
    ArrayList localArrayList = localBundle.getParcelableArrayList("order_product_list");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.uQh.clear();
      this.uQh.addAll(localArrayList);
    }
    this.wXY = localBundle.getString("key_trans_id");
    this.nSt = localBundle.getString("appname");
    this.bEw = ((ListView)findViewById(a.f.order_product_list));
    this.wyr = new a((byte)0);
    this.bEw.setAdapter(this.wyr);
    this.wyr.notifyDataSetChanged();
    this.bEw.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66743);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderProductListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (ProductSectionItem)MallOrderProductListUI.a(MallOrderProductListUI.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          MallOrderProductListUI.a(MallOrderProductListUI.this, paramAnonymousAdapterView);
          c.a(Boolean.FALSE, MallOrderProductListUI.b(MallOrderProductListUI.this), MallOrderProductListUI.c(MallOrderProductListUI.this), paramAnonymousAdapterView.name, paramAnonymousAdapterView.ycW);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderProductListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66743);
      }
    });
    AppMethodBeat.o(66752);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66751);
    super.onCreate(paramBundle);
    setContentViewVisibility(0);
    initView();
    AppMethodBeat.o(66751);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66753);
    super.onDestroy();
    AppMethodBeat.o(66753);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66754);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.cm(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.cj(this);
      }
      AppMethodBeat.o(66754);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66754);
    return bool;
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private ProductSectionItem afm(int paramInt)
    {
      AppMethodBeat.i(66745);
      ProductSectionItem localProductSectionItem = (ProductSectionItem)MallOrderProductListUI.a(MallOrderProductListUI.this).get(paramInt);
      AppMethodBeat.o(66745);
      return localProductSectionItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66744);
      int i = MallOrderProductListUI.a(MallOrderProductListUI.this).size();
      AppMethodBeat.o(66744);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66746);
      ProductSectionItem localProductSectionItem;
      if (paramView == null)
      {
        paramView = View.inflate(MallOrderProductListUI.this, a.g.mall_order_product_list_item, null);
        paramViewGroup = new MallOrderProductListUI.b(MallOrderProductListUI.this, (byte)0);
        paramViewGroup.wDN = ((ImageView)paramView.findViewById(a.f.item_product_logo_img));
        paramViewGroup.MFT = ((TextView)paramView.findViewById(a.f.item_product_descript_tv));
        paramViewGroup.MFU = ((TextView)paramView.findViewById(a.f.item_product_catalog_tv));
        paramViewGroup.MFV = ((TextView)paramView.findViewById(a.f.item_product_price_tv));
        paramViewGroup.MFW = ((TextView)paramView.findViewById(a.f.item_product_count_tv));
        paramViewGroup.MFX = ((TextView)paramView.findViewById(a.f.item_product_seperator_tv));
        paramView.setTag(paramViewGroup);
        localProductSectionItem = afm(paramInt);
        paramViewGroup.nQG = localProductSectionItem.iconUrl;
        if ((TextUtils.isEmpty(paramViewGroup.nQG)) || (!i.bEM(paramViewGroup.nQG))) {
          break label282;
        }
        Bitmap localBitmap = r.a(new com.tencent.mm.plugin.order.c.b(paramViewGroup.nQG));
        paramViewGroup.wDN.setImageBitmap(localBitmap);
      }
      for (;;)
      {
        paramViewGroup.MFT.setText(localProductSectionItem.name);
        paramViewGroup.MFU.setText(ProductSectionItem.Skus.jn(localProductSectionItem.MFA));
        paramViewGroup.MFV.setText(localProductSectionItem.price);
        paramViewGroup.MFW.setText("+" + localProductSectionItem.count);
        r.a(paramViewGroup);
        paramViewGroup.MFX.setVisibility(8);
        AppMethodBeat.o(66746);
        return paramView;
        paramViewGroup = (MallOrderProductListUI.b)paramView.getTag();
        break;
        label282:
        paramViewGroup.wDN.setImageResource(a.h.mall_order_detail_frame);
      }
    }
  }
  
  final class b
    implements r.a
  {
    TextView MFT;
    TextView MFU;
    TextView MFV;
    TextView MFW;
    TextView MFX;
    String nQG;
    ImageView wDN;
    
    private b() {}
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(66749);
      if ((paramString != null) && (paramString.equals(this.nQG))) {
        this.wDN.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66748);
            MallOrderProductListUI.b.this.wDN.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66748);
          }
        });
      }
      AppMethodBeat.o(66749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI
 * JD-Core Version:    0.7.0.1
 */