package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI
  extends WalletBaseUI
{
  private ListView GP;
  private String ixZ;
  private List<ProductSectionItem> opg;
  private BaseAdapter pXY;
  private String qvD;
  
  public MallOrderProductListUI()
  {
    AppMethodBeat.i(66750);
    this.opg = new ArrayList();
    this.qvD = "";
    this.ixZ = "";
    AppMethodBeat.o(66750);
  }
  
  public int getLayoutId()
  {
    return 2131495451;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(66752);
    setMMTitle(2131762898);
    Bundle localBundle = getInput();
    ArrayList localArrayList = localBundle.getParcelableArrayList("order_product_list");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.opg.clear();
      this.opg.addAll(localArrayList);
    }
    this.qvD = localBundle.getString("key_trans_id");
    this.ixZ = localBundle.getString("appname");
    this.GP = ((ListView)findViewById(2131305690));
    this.pXY = new a((byte)0);
    this.GP.setAdapter(this.pXY);
    this.pXY.notifyDataSetChanged();
    this.GP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66743);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderProductListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (ProductSectionItem)MallOrderProductListUI.a(MallOrderProductListUI.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          MallOrderProductListUI.a(MallOrderProductListUI.this, paramAnonymousAdapterView);
          c.a(Boolean.FALSE, MallOrderProductListUI.b(MallOrderProductListUI.this), MallOrderProductListUI.c(MallOrderProductListUI.this), paramAnonymousAdapterView.name, paramAnonymousAdapterView.APx);
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
      if ((com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bv(this);
      }
      AppMethodBeat.o(66754);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66754);
    return bool;
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private ProductSectionItem Uj(int paramInt)
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
        paramView = View.inflate(MallOrderProductListUI.this, 2131495452, null);
        paramViewGroup = new MallOrderProductListUI.b(MallOrderProductListUI.this, (byte)0);
        paramViewGroup.qdu = ((ImageView)paramView.findViewById(2131302852));
        paramViewGroup.APT = ((TextView)paramView.findViewById(2131302851));
        paramViewGroup.APU = ((TextView)paramView.findViewById(2131302848));
        paramViewGroup.APV = ((TextView)paramView.findViewById(2131302853));
        paramViewGroup.APW = ((TextView)paramView.findViewById(2131302849));
        paramViewGroup.APX = ((TextView)paramView.findViewById(2131302854));
        paramView.setTag(paramViewGroup);
        localProductSectionItem = Uj(paramInt);
        paramViewGroup.iwv = localProductSectionItem.iconUrl;
        if ((TextUtils.isEmpty(paramViewGroup.iwv)) || (!f.bpr(paramViewGroup.iwv))) {
          break label275;
        }
        Bitmap localBitmap = u.a(new com.tencent.mm.plugin.order.c.b(paramViewGroup.iwv));
        paramViewGroup.qdu.setImageBitmap(localBitmap);
      }
      for (;;)
      {
        paramViewGroup.APT.setText(localProductSectionItem.name);
        paramViewGroup.APU.setText(ProductSectionItem.Skus.fJ(localProductSectionItem.APw));
        paramViewGroup.APV.setText(localProductSectionItem.price);
        paramViewGroup.APW.setText("+" + localProductSectionItem.count);
        u.a(paramViewGroup);
        paramViewGroup.APX.setVisibility(8);
        AppMethodBeat.o(66746);
        return paramView;
        paramViewGroup = (MallOrderProductListUI.b)paramView.getTag();
        break;
        label275:
        paramViewGroup.qdu.setImageResource(2131691064);
      }
    }
  }
  
  final class b
    implements u.a
  {
    TextView APT;
    TextView APU;
    TextView APV;
    TextView APW;
    TextView APX;
    String iwv;
    ImageView qdu;
    
    private b() {}
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(66749);
      if ((paramString != null) && (paramString.equals(this.iwv))) {
        this.qdu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66748);
            MallOrderProductListUI.b.this.qdu.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66748);
          }
        });
      }
      AppMethodBeat.o(66749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI
 * JD-Core Version:    0.7.0.1
 */