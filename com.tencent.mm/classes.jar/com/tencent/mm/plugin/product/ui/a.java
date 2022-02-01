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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context wNa;
  private List<com.tencent.mm.plugin.product.c.a> wNb;
  private List<Boolean> wNc;
  private int wNd = 1;
  
  public a(Context paramContext)
  {
    this.wNa = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a MB(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.wNb.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    ad.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    ad.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.wNh);
    switch (paramView.type)
    {
    case 3: 
    default: 
      ad.w("MicroMsg.MallCustomActionAdapter", "not support type");
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
          } while (!(paramView.wNh instanceof String));
          e.a(this.wNa, (String)paramView.wNh, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.wNh instanceof ArrayList));
        paramView = (ArrayList)paramView.wNh;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramView.ahp(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.wNh instanceof String));
      Object localObject = (String)paramView.wNh;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      e.an(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.wNc.get(paramInt)).booleanValue()) {
      this.wNc.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.wNc.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void eL(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.wNb = paramList;
    this.wNd = 0;
    this.wNc = new ArrayList();
    if (this.wNb != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.wNc.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.nEf));
      }
      this.wNd = paramList.size();
    }
    if (this.wNd <= 0) {
      this.wNd = 1;
    }
    AppMethodBeat.o(66935);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.wNb != null)
    {
      int i = this.wNb.size();
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
    paramInt = MB(paramInt).nEf;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.wNa, 2131495121, null);
      paramViewGroup = new b();
      paramViewGroup.lCL = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.wNe = ((TextView)paramView.findViewById(2131305553));
      paramViewGroup.wNf = ((ImageView)paramView.findViewById(2131300997));
      paramViewGroup.wNg = ((HtmlTextView)paramView.findViewById(2131299046));
      paramView.setTag(paramViewGroup);
      locala = MB(paramInt);
      if (locala != null)
      {
        paramViewGroup.lCL.setText(locala.Name);
        paramViewGroup.wNe.setText(locala.wMs);
        paramViewGroup.type = locala.nEf;
        paramViewGroup.wNh = locala.hDa;
        paramViewGroup.title = locala.Name;
        switch (locala.nEf)
        {
        }
      }
    }
    label301:
    for (;;)
    {
      AppMethodBeat.o(66940);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.wNf.setVisibility(8);
      continue;
      if (((Boolean)this.wNc.get(paramInt)).booleanValue()) {
        paramViewGroup.wNg.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.wNg.getText().equals(locala.hDa)) {
          break label301;
        }
        paramViewGroup.wNg.setText(locala.hDa);
        break;
        paramViewGroup.wNg.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.wNd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */