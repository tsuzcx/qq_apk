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
import com.tencent.mm.al.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.order.c.b;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI
  extends WalletBaseUI
{
  private ListView DQ;
  private String gIw;
  private List<ProductSectionItem> lWb;
  private String nSY;
  private BaseAdapter nxo;
  
  public MallOrderProductListUI()
  {
    AppMethodBeat.i(66750);
    this.lWb = new ArrayList();
    this.nSY = "";
    this.gIw = "";
    AppMethodBeat.o(66750);
  }
  
  public int getLayoutId()
  {
    return 2131494722;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(66752);
    setMMTitle(2131761111);
    Bundle localBundle = getInput();
    ArrayList localArrayList = localBundle.getParcelableArrayList("order_product_list");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.lWb.clear();
      this.lWb.addAll(localArrayList);
    }
    this.nSY = localBundle.getString("key_trans_id");
    this.gIw = localBundle.getString("appname");
    this.DQ = ((ListView)findViewById(2131303082));
    this.nxo = new a((byte)0);
    this.DQ.setAdapter(this.nxo);
    this.nxo.notifyDataSetChanged();
    this.DQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66743);
        paramAnonymousAdapterView = (ProductSectionItem)MallOrderProductListUI.a(MallOrderProductListUI.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          MallOrderProductListUI.a(MallOrderProductListUI.this, paramAnonymousAdapterView);
          c.a(Boolean.FALSE, MallOrderProductListUI.b(MallOrderProductListUI.this), MallOrderProductListUI.c(MallOrderProductListUI.this), paramAnonymousAdapterView.name, paramAnonymousAdapterView.upD);
        }
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
      if ((com.tencent.mm.wallet_core.a.bo(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bl(this);
      }
      AppMethodBeat.o(66754);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66754);
    return bool;
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private ProductSectionItem IT(int paramInt)
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
        paramView = View.inflate(MallOrderProductListUI.this, 2131494723, null);
        paramViewGroup = new MallOrderProductListUI.b(MallOrderProductListUI.this, (byte)0);
        paramViewGroup.nCK = ((ImageView)paramView.findViewById(2131301180));
        paramViewGroup.upW = ((TextView)paramView.findViewById(2131301179));
        paramViewGroup.upX = ((TextView)paramView.findViewById(2131301176));
        paramViewGroup.upY = ((TextView)paramView.findViewById(2131301181));
        paramViewGroup.upZ = ((TextView)paramView.findViewById(2131301177));
        paramViewGroup.uqa = ((TextView)paramView.findViewById(2131301182));
        paramView.setTag(paramViewGroup);
        localProductSectionItem = IT(paramInt);
        paramViewGroup.gGR = localProductSectionItem.iconUrl;
        if ((TextUtils.isEmpty(paramViewGroup.gGR)) || (!e.aNe(paramViewGroup.gGR))) {
          break label275;
        }
        Bitmap localBitmap = u.a(new b(paramViewGroup.gGR));
        paramViewGroup.nCK.setImageBitmap(localBitmap);
      }
      for (;;)
      {
        paramViewGroup.upW.setText(localProductSectionItem.name);
        paramViewGroup.upX.setText(ProductSectionItem.Skus.eo(localProductSectionItem.upB));
        paramViewGroup.upY.setText(localProductSectionItem.upC);
        paramViewGroup.upZ.setText("+" + localProductSectionItem.count);
        u.a(paramViewGroup);
        paramViewGroup.uqa.setVisibility(8);
        AppMethodBeat.o(66746);
        return paramView;
        paramViewGroup = (MallOrderProductListUI.b)paramView.getTag();
        break;
        label275:
        paramViewGroup.nCK.setImageResource(2131690780);
      }
    }
  }
  
  final class b
    implements u.a
  {
    String gGR;
    ImageView nCK;
    TextView upW;
    TextView upX;
    TextView upY;
    TextView upZ;
    TextView uqa;
    
    private b() {}
    
    public final void l(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(66749);
      if ((paramString != null) && (paramString.equals(this.gGR))) {
        this.nCK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66748);
            MallOrderProductListUI.b.this.nCK.setImageBitmap(paramBitmap);
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