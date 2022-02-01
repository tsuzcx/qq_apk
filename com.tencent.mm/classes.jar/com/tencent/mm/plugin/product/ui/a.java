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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context Baq;
  private List<com.tencent.mm.plugin.product.c.a> Bar;
  private List<Boolean> Bas;
  private int Bat = 1;
  
  public a(Context paramContext)
  {
    this.Baq = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a Uu(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.Bar.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    Log.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.Bax);
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
          } while (!(paramView.Bax instanceof String));
          f.a(this.Baq, (String)paramView.Bax, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.Bax instanceof ArrayList));
        paramView = (ArrayList)paramView.Bax;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramView.axQ(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.Bax instanceof String));
      Object localObject = (String)paramView.Bax;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      f.aA(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.Bas.get(paramInt)).booleanValue()) {
      this.Bas.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.Bas.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void fO(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.Bar = paramList;
    this.Bat = 0;
    this.Bas = new ArrayList();
    if (this.Bar != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.Bas.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.oUv));
      }
      this.Bat = paramList.size();
    }
    if (this.Bat <= 0) {
      this.Bat = 1;
    }
    AppMethodBeat.o(66935);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.Bar != null)
    {
      int i = this.Bar.size();
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
    paramInt = Uu(paramInt).oUv;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.Baq, 2131495964, null);
      paramViewGroup = new b();
      paramViewGroup.mPa = ((TextView)paramView.findViewById(2131309249));
      paramViewGroup.Bau = ((TextView)paramView.findViewById(2131308774));
      paramViewGroup.Bav = ((ImageView)paramView.findViewById(2131302638));
      paramViewGroup.Baw = ((HtmlTextView)paramView.findViewById(2131299552));
      paramView.setTag(paramViewGroup);
      locala = Uu(paramInt);
      if (locala != null)
      {
        paramViewGroup.mPa.setText(locala.Name);
        paramViewGroup.Bau.setText(locala.AZI);
        paramViewGroup.type = locala.oUv;
        paramViewGroup.Bax = locala.iAc;
        paramViewGroup.title = locala.Name;
        switch (locala.oUv)
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
      paramViewGroup.Bav.setVisibility(8);
      continue;
      if (((Boolean)this.Bas.get(paramInt)).booleanValue()) {
        paramViewGroup.Baw.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.Baw.getText().equals(locala.iAc)) {
          break label301;
        }
        paramViewGroup.Baw.setText(locala.iAc);
        break;
        paramViewGroup.Baw.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.Bat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */