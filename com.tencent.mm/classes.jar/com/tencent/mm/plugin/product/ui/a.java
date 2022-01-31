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
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context pvr;
  private List<com.tencent.mm.plugin.product.c.a> pvs;
  private List<Boolean> pvt;
  private int pvu = 1;
  
  public a(Context paramContext)
  {
    this.pvr = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a Bn(int paramInt)
  {
    AppMethodBeat.i(44031);
    com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)this.pvs.get(paramInt);
    AppMethodBeat.o(44031);
    return locala;
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    AppMethodBeat.i(44029);
    paramView = (b)paramView.getTag();
    ab.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    ab.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.pvy);
    switch (paramView.type)
    {
    case 3: 
    default: 
      ab.w("MicroMsg.MallCustomActionAdapter", "not support type");
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
            AppMethodBeat.o(44029);
            return;
            AppMethodBeat.o(44029);
            return;
          } while (!(paramView.pvy instanceof String));
          paramActivity = new Intent();
          paramActivity.putExtra("rawUrl", (String)paramView.pvy);
          paramActivity.putExtra("showShare", false);
          d.b(this.pvr, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramActivity, 10000);
          AppMethodBeat.o(44029);
          return;
        } while (!(paramView.pvy instanceof ArrayList));
        paramView = (ArrayList)paramView.pvy;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramActivity.startActivity((Intent)localObject);
        AppMethodBeat.o(44029);
        return;
      } while (!(paramView.pvy instanceof String));
      Object localObject = (String)paramView.pvy;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      d.b(paramActivity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(44029);
      return;
    }
    if (((Boolean)this.pvt.get(paramInt)).booleanValue()) {
      this.pvt.set(paramInt, Boolean.FALSE);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(44029);
      return;
      this.pvt.set(paramInt, Boolean.TRUE);
    }
  }
  
  public final void cx(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    AppMethodBeat.i(44028);
    this.pvs = paramList;
    this.pvu = 0;
    this.pvt = new ArrayList();
    if (this.pvs != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.pvt.add(Boolean.FALSE);
        localHashSet.add(Integer.valueOf(locala.jKs));
      }
      this.pvu = paramList.size();
    }
    if (this.pvu <= 0) {
      this.pvu = 1;
    }
    AppMethodBeat.o(44028);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44030);
    if (this.pvs != null)
    {
      int i = this.pvs.size();
      AppMethodBeat.o(44030);
      return i;
    }
    AppMethodBeat.o(44030);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(44032);
    paramInt = Bn(paramInt).jKs;
    AppMethodBeat.o(44032);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44033);
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.pvr, 2130970448, null);
      paramViewGroup = new b();
      paramViewGroup.iJG = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.pvv = ((TextView)paramView.findViewById(2131826794));
      paramViewGroup.pvw = ((ImageView)paramView.findViewById(2131826795));
      paramViewGroup.pvx = ((HtmlTextView)paramView.findViewById(2131826796));
      paramView.setTag(paramViewGroup);
      locala = Bn(paramInt);
      if (locala != null)
      {
        paramViewGroup.iJG.setText(locala.Name);
        paramViewGroup.pvv.setText(locala.puI);
        paramViewGroup.type = locala.jKs;
        paramViewGroup.pvy = locala.ntu;
        paramViewGroup.title = locala.Name;
        switch (locala.jKs)
        {
        }
      }
    }
    label296:
    for (;;)
    {
      AppMethodBeat.o(44033);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.pvw.setVisibility(8);
      continue;
      if (((Boolean)this.pvt.get(paramInt)).booleanValue()) {
        paramViewGroup.pvx.setVisibility(0);
      }
      for (;;)
      {
        if (paramViewGroup.pvx.getText().equals(locala.ntu)) {
          break label296;
        }
        paramViewGroup.pvx.setText(locala.ntu);
        break;
        paramViewGroup.pvx.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.pvu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */