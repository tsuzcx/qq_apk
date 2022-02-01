package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context MRR;
  private List<com.tencent.mm.plugin.product.b.a> MRS;
  private List<Boolean> MRT;
  private int MRU = 1;
  
  public a(Context paramContext)
  {
    this.MRR = paramContext;
  }
  
  private com.tencent.mm.plugin.product.b.a afz(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.b.a locala = (com.tencent.mm.plugin.product.b.a)this.MRS.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.aeq);
    switch (paramView.type)
    {
    case 3: 
    default: 
      Log.w("MicroMsg.MallCustomActionAdapter", "not support type");
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 6: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(66936);
            return;
            AppMethodBeat.o(66936);
            return;
          } while (!(paramView.aeq instanceof String));
          i.a(this.MRR, (String)paramView.aeq, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.aeq instanceof ArrayList));
        paramView = (ArrayList)paramView.aeq;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramView.aYi(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.aeq instanceof String));
      Object localObject = (String)paramView.aeq;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      i.aS(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.MRT.get(paramInt)).booleanValue()) {
      this.MRT.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.MRT.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.MRS != null)
    {
      int i = this.MRS.size();
      AppMethodBeat.o(66937);
      return i;
    }
    AppMethodBeat.o(66937);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(66939);
    paramInt = afz(paramInt).vhJ;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.b.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.MRR, a.g.product_item_view, null);
      paramViewGroup = new b();
      paramViewGroup.sUt = ((TextView)paramView.findViewById(a.f.title_tv));
      paramViewGroup.MRV = ((TextView)paramView.findViewById(a.f.summary_tv));
      paramViewGroup.MRW = ((ImageView)paramView.findViewById(a.f.indecator_iv));
      paramViewGroup.MRX = ((HtmlTextView)paramView.findViewById(a.f.detail_htv));
      paramView.setTag(paramViewGroup);
      locala = afz(paramInt);
      if (locala != null)
      {
        paramViewGroup.sUt.setText(locala.IGU);
        paramViewGroup.MRV.setText(locala.MRj);
        paramViewGroup.type = locala.vhJ;
        paramViewGroup.aeq = locala.nUB;
        paramViewGroup.title = locala.IGU;
        switch (locala.vhJ)
        {
        }
      }
    }
    label300:
    for (;;)
    {
      AppMethodBeat.o(66940);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.MRW.setVisibility(8);
      continue;
      if (((Boolean)this.MRT.get(paramInt)).booleanValue()) {
        paramViewGroup.MRX.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.MRX.getText().equals(locala.nUB)) {
          break label300;
        }
        paramViewGroup.MRX.setText(locala.nUB);
        break;
        paramViewGroup.MRX.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.MRU;
  }
  
  public final void js(List<com.tencent.mm.plugin.product.b.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.MRS = paramList;
    this.MRU = 0;
    this.MRT = new ArrayList();
    if (this.MRS != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.b.a locala = (com.tencent.mm.plugin.product.b.a)localIterator.next();
        this.MRT.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.vhJ));
      }
      this.MRU = paramList.size();
    }
    if (this.MRU <= 0) {
      this.MRU = 1;
    }
    AppMethodBeat.o(66935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */