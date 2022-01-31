package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
{
  private Context mTl;
  private List<com.tencent.mm.plugin.product.c.a> mTm;
  private List<Boolean> mTn;
  private int mTo = 1;
  
  public a(Context paramContext)
  {
    this.mTl = paramContext;
  }
  
  private com.tencent.mm.plugin.product.c.a vO(int paramInt)
  {
    return (com.tencent.mm.plugin.product.c.a)this.mTm.get(paramInt);
  }
  
  public final void a(Activity paramActivity, View paramView, int paramInt)
  {
    paramView = (b)paramView.getTag();
    y.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + paramView.type);
    y.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + paramView.mTs);
    switch (paramView.type)
    {
    case 3: 
    default: 
      y.w("MicroMsg.MallCustomActionAdapter", "not support type");
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
            return;
          } while (!(paramView.mTs instanceof String));
          paramActivity = new Intent();
          paramActivity.putExtra("rawUrl", (String)paramView.mTs);
          paramActivity.putExtra("showShare", false);
          d.b(this.mTl, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramActivity, 10000);
          return;
        } while (!(paramView.mTs instanceof ArrayList));
        paramView = (ArrayList)paramView.mTs;
        localObject = new Intent(paramActivity, MallGalleryUI.class);
        ((Intent)localObject).putExtra("keys_img_urls", paramView);
        paramActivity.startActivity((Intent)localObject);
        return;
      } while (!(paramView.mTs instanceof String));
      Object localObject = (String)paramView.mTs;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", paramView.title);
      localIntent.putExtra("neverGetA8Key", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("data", (String)localObject);
      localIntent.putExtra("QRDataFlag", false);
      d.b(paramActivity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      return;
    }
    if (((Boolean)this.mTn.get(paramInt)).booleanValue()) {
      this.mTn.set(paramInt, Boolean.valueOf(false));
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.mTn.set(paramInt, Boolean.valueOf(true));
    }
  }
  
  public final void bW(List<com.tencent.mm.plugin.product.c.a> paramList)
  {
    this.mTm = paramList;
    this.mTo = 0;
    this.mTn = new ArrayList();
    if (this.mTm != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.product.c.a locala = (com.tencent.mm.plugin.product.c.a)localIterator.next();
        this.mTn.add(Boolean.valueOf(false));
        localHashSet.add(Integer.valueOf(locala.hQR));
      }
      this.mTo = paramList.size();
    }
    if (this.mTo <= 0) {
      this.mTo = 1;
    }
  }
  
  public final int getCount()
  {
    if (this.mTm != null) {
      return this.mTm.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return vO(paramInt).hQR;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.product.c.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.mTl, a.g.product_item_view, null);
      paramViewGroup = new b();
      paramViewGroup.haW = ((TextView)paramView.findViewById(a.f.title_tv));
      paramViewGroup.mTp = ((TextView)paramView.findViewById(a.f.summary_tv));
      paramViewGroup.mTq = ((ImageView)paramView.findViewById(a.f.indecator_iv));
      paramViewGroup.mTr = ((HtmlTextView)paramView.findViewById(a.f.detail_htv));
      paramView.setTag(paramViewGroup);
      locala = vO(paramInt);
      if (locala != null)
      {
        paramViewGroup.haW.setText(locala.kRZ);
        paramViewGroup.mTp.setText(locala.mSC);
        paramViewGroup.type = locala.hQR;
        paramViewGroup.mTs = locala.kVs;
        paramViewGroup.title = locala.kRZ;
        switch (locala.hQR)
        {
        }
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.mTq.setVisibility(8);
      return paramView;
      if (((Boolean)this.mTn.get(paramInt)).booleanValue()) {
        paramViewGroup.mTr.setVisibility(0);
      }
      while (!paramViewGroup.mTr.getText().equals(locala.kVs))
      {
        paramViewGroup.mTr.setText(locala.kVs);
        return paramView;
        paramViewGroup.mTr.setVisibility(8);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.mTo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.a
 * JD-Core Version:    0.7.0.1
 */