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
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context GUo;
  private List<com.tencent.mm.plugin.product.c.a> GUp;
  private List<Boolean> GUq;
  private int GUr = 1;
  
  public a(Context paramContext)
  {
    this.GUo = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a abg(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.GUp.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.GUv);
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
          } while (!(paramView.GUv instanceof String));
          g.a(this.GUo, (String)paramView.GUv, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.GUv instanceof ArrayList));
        paramView = (ArrayList)paramView.GUv;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramView.aFh(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.GUv instanceof String));
      Object localObject = (String)paramView.GUv;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      g.aJ(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.GUq.get(paramInt)).booleanValue()) {
      this.GUq.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.GUq.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.GUp != null)
    {
      int i = this.GUp.size();
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
    paramInt = abg(paramInt).rWu;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.GUo, a.g.product_item_view, null);
      paramViewGroup = new b();
      paramViewGroup.pPT = ((TextView)paramView.findViewById(a.f.title_tv));
      paramViewGroup.GUs = ((TextView)paramView.findViewById(a.f.summary_tv));
      paramViewGroup.GUt = ((ImageView)paramView.findViewById(a.f.indecator_iv));
      paramViewGroup.GUu = ((HtmlTextView)paramView.findViewById(a.f.detail_htv));
      paramView.setTag(paramViewGroup);
      locala = abg(paramInt);
      if (locala != null)
      {
        paramViewGroup.pPT.setText(locala.CMP);
        paramViewGroup.GUs.setText(locala.GTG);
        paramViewGroup.type = locala.rWu;
        paramViewGroup.GUv = locala.lpy;
        paramViewGroup.title = locala.CMP;
        switch (locala.rWu)
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
      paramViewGroup.GUt.setVisibility(8);
      continue;
      if (((Boolean)this.GUq.get(paramInt)).booleanValue()) {
        paramViewGroup.GUu.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.GUu.getText().equals(locala.lpy)) {
          break label300;
        }
        paramViewGroup.GUu.setText(locala.lpy);
        break;
        paramViewGroup.GUu.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.GUr;
  }
  
  public final void gs(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.GUp = paramList;
    this.GUr = 0;
    this.GUq = new ArrayList();
    if (this.GUp != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.GUq.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.rWu));
      }
      this.GUr = paramList.size();
    }
    if (this.GUr <= 0) {
      this.GUr = 1;
    }
    AppMethodBeat.o(66935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */