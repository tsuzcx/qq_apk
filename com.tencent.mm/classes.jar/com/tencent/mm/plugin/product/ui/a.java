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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context xcO;
  private List<com.tencent.mm.plugin.product.c.a> xcP;
  private List<Boolean> xcQ;
  private int xcR = 1;
  
  public a(Context paramContext)
  {
    this.xcO = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a Nh(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.xcP.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    ae.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    ae.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.xcV);
    switch (paramView.type)
    {
    case 3: 
    default: 
      ae.w("MicroMsg.MallCustomActionAdapter", "not support type");
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
          } while (!(paramView.xcV instanceof String));
          f.a(this.xcO, (String)paramView.xcV, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.xcV instanceof ArrayList));
        paramView = (ArrayList)paramView.xcV;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramView.ahE(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.xcV instanceof String));
      Object localObject = (String)paramView.xcV;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      f.an(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.xcQ.get(paramInt)).booleanValue()) {
      this.xcQ.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.xcQ.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void eT(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.xcP = paramList;
    this.xcR = 0;
    this.xcQ = new ArrayList();
    if (this.xcP != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.xcQ.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.nJA));
      }
      this.xcR = paramList.size();
    }
    if (this.xcR <= 0) {
      this.xcR = 1;
    }
    AppMethodBeat.o(66935);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.xcP != null)
    {
      int i = this.xcP.size();
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
    paramInt = Nh(paramInt).nJA;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.xcO, 2131495121, null);
      paramViewGroup = new b();
      paramViewGroup.lHk = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.xcS = ((TextView)paramView.findViewById(2131305553));
      paramViewGroup.xcT = ((ImageView)paramView.findViewById(2131300997));
      paramViewGroup.xcU = ((HtmlTextView)paramView.findViewById(2131299046));
      paramView.setTag(paramViewGroup);
      locala = Nh(paramInt);
      if (locala != null)
      {
        paramViewGroup.lHk.setText(locala.Name);
        paramViewGroup.xcS.setText(locala.xcg);
        paramViewGroup.type = locala.nJA;
        paramViewGroup.xcV = locala.hFS;
        paramViewGroup.title = locala.Name;
        switch (locala.nJA)
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
      paramViewGroup.xcT.setVisibility(8);
      continue;
      if (((Boolean)this.xcQ.get(paramInt)).booleanValue()) {
        paramViewGroup.xcU.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.xcU.getText().equals(locala.hFS)) {
          break label301;
        }
        paramViewGroup.xcU.setText(locala.hFS);
        break;
        paramViewGroup.xcU.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.xcR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */