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
  private Context uxb;
  private List<com.tencent.mm.plugin.product.c.a> uxc;
  private List<Boolean> uxd;
  private int uxe = 1;
  
  public a(Context paramContext)
  {
    this.uxb = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a IZ(int paramInt)
  {
    AppMethodBeat.i(66938);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.uxc.get(paramInt);
    AppMethodBeat.o(66938);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(66936);
    paramView = (b)paramView.getTag();
    ad.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    ad.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.uxi);
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
          } while (!(paramView.uxi instanceof String));
          e.a(this.uxb, (String)paramView.uxi, false, 10000);
          AppMethodBeat.o(66936);
          return;
        } while (!(paramView.uxi instanceof ArrayList));
        paramView = (ArrayList)paramView.uxi;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramView.adn(), "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/product/ui/MallCustomActionAdapter", "onItemClick", "(Landroid/app/Activity;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66936);
        return;
      } while (!(paramView.uxi instanceof String));
      Object localObject = (String)paramView.uxi;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      e.X(paramActivity, localIntent);
      AppMethodBeat.o(66936);
      return;
    }
    if (((Boolean)this.uxd.get(paramInt)).booleanValue()) {
      this.uxd.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(66936);
      return;
      this.uxd.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void eu(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(66935);
    this.uxc = paramList;
    this.uxe = 0;
    this.uxd = new ArrayList();
    if (this.uxc != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.uxd.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.mBH));
      }
      this.uxe = paramList.size();
    }
    if (this.uxe <= 0) {
      this.uxe = 1;
    }
    AppMethodBeat.o(66935);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66937);
    if (this.uxc != null)
    {
      int i = this.uxc.size();
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
    paramInt = IZ(paramInt).mBH;
    AppMethodBeat.o(66939);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66940);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.uxb, 2131495121, null);
      paramViewGroup = new b();
      paramViewGroup.kEu = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.uxf = ((TextView)paramView.findViewById(2131305553));
      paramViewGroup.uxg = ((ImageView)paramView.findViewById(2131300997));
      paramViewGroup.uxh = ((HtmlTextView)paramView.findViewById(2131299046));
      paramView.setTag(paramViewGroup);
      locala = IZ(paramInt);
      if (locala != null)
      {
        paramViewGroup.kEu.setText(locala.Name);
        paramViewGroup.uxf.setText(locala.uwt);
        paramViewGroup.type = locala.mBH;
        paramViewGroup.uxi = locala.gKr;
        paramViewGroup.title = locala.Name;
        switch (locala.mBH)
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
      paramViewGroup.uxg.setVisibility(8);
      continue;
      if (((Boolean)this.uxd.get(paramInt)).booleanValue()) {
        paramViewGroup.uxh.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.uxh.getText().equals(locala.gKr)) {
          break label301;
        }
        paramViewGroup.uxh.setText(locala.gKr);
        break;
        paramViewGroup.uxh.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.uxe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */