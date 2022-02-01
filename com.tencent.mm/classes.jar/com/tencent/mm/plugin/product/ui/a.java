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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context vFU;
  private List<com.tencent.mm.plugin.product.c.a> vFV;
  private List<Boolean> vFW;
  private int vFX = 1;
  
  public a(Context paramContext)
  {
    this.vFU = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a KY(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.vFV.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    ac.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    ac.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.vGb);
    switch (paramView.type)
    {
    case 3: 
    default: 
      ac.w("MicroMsg.MallCustomActionAdapter", "not support type");
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
          } while (!(paramView.vGb instanceof String));
          e.a(this.vFU, (String)paramView.vGb, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.vGb instanceof ArrayList));
        paramView = (ArrayList)paramView.vGb;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramView.aeD(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.vGb instanceof String));
      Object localObject = (String)paramView.vGb;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      e.al(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.vFW.get(paramInt)).booleanValue()) {
      this.vFW.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.vFW.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void ey(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.vFV = paramList;
    this.vFX = 0;
    this.vFW = new ArrayList();
    if (this.vFV != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.vFW.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.ndI));
      }
      this.vFX = paramList.size();
    }
    if (this.vFX <= 0) {
      this.vFX = 1;
    }
    AppMethodBeat.o(66935);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.vFV != null)
    {
      int i = this.vFV.size();
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
    paramInt = KY(paramInt).ndI;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.vFU, 2131495121, null);
      paramViewGroup = new b();
      paramViewGroup.lfN = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.vFY = ((TextView)paramView.findViewById(2131305553));
      paramViewGroup.vFZ = ((ImageView)paramView.findViewById(2131300997));
      paramViewGroup.vGa = ((HtmlTextView)paramView.findViewById(2131299046));
      paramView.setTag(paramViewGroup);
      locala = KY(paramInt);
      if (locala != null)
      {
        paramViewGroup.lfN.setText(locala.Name);
        paramViewGroup.vFY.setText(locala.vFm);
        paramViewGroup.type = locala.ndI;
        paramViewGroup.vGb = locala.hkR;
        paramViewGroup.title = locala.Name;
        switch (locala.ndI)
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
      paramViewGroup.vFZ.setVisibility(8);
      continue;
      if (((Boolean)this.vFW.get(paramInt)).booleanValue()) {
        paramViewGroup.vGa.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.vGa.getText().equals(locala.hkR)) {
          break label301;
        }
        paramViewGroup.vGa.setText(locala.hkR);
        break;
        paramViewGroup.vGa.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.vFX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */