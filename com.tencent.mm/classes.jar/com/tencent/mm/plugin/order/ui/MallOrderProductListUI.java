package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI
  extends WalletBaseUI
{
  private String fhP;
  private List<ProductSectionItem> jfV;
  private String kMN;
  private BaseAdapter krV;
  private ListView xx;
  
  public MallOrderProductListUI()
  {
    AppMethodBeat.i(43842);
    this.jfV = new ArrayList();
    this.kMN = "";
    this.fhP = "";
    AppMethodBeat.o(43842);
  }
  
  public int getLayoutId()
  {
    return 2130970108;
  }
  
  @Deprecated
  public void initView()
  {
    AppMethodBeat.i(43845);
    setMMTitle(2131301464);
    Bundle localBundle = getInput();
    ArrayList localArrayList = localBundle.getParcelableArrayList("order_product_list");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jfV.clear();
      this.jfV.addAll(localArrayList);
    }
    this.kMN = localBundle.getString("key_trans_id");
    this.fhP = localBundle.getString("appname");
    this.xx = ((ListView)findViewById(2131826020));
    this.krV = new MallOrderProductListUI.a(this, (byte)0);
    this.xx.setAdapter(this.krV);
    this.krV.notifyDataSetChanged();
    this.xx.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(43835);
        paramAnonymousAdapterView = (ProductSectionItem)MallOrderProductListUI.a(MallOrderProductListUI.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          MallOrderProductListUI.a(MallOrderProductListUI.this, paramAnonymousAdapterView);
          c.a(Boolean.FALSE, MallOrderProductListUI.b(MallOrderProductListUI.this), MallOrderProductListUI.c(MallOrderProductListUI.this), paramAnonymousAdapterView.name, paramAnonymousAdapterView.pqD);
        }
        AppMethodBeat.o(43835);
      }
    });
    AppMethodBeat.o(43845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43843);
    super.onCreate(paramBundle);
    setContentViewVisibility(0);
    initView();
    AppMethodBeat.o(43843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43846);
    super.onDestroy();
    AppMethodBeat.o(43846);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43847);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.aM(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.aJ(this);
      }
      AppMethodBeat.o(43847);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(43847);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI
 * JD-Core Version:    0.7.0.1
 */