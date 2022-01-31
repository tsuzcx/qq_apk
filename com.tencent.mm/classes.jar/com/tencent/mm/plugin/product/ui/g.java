package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends n
{
  Context mContext;
  private ArrayList<g.b> mTR;
  private boolean mTS = false;
  g.a mTT = null;
  private List<String> mTv;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    this.mContext = paramContext;
    this.mTv = null;
    setData(this.mTv);
  }
  
  public final int F(Object paramObject)
  {
    return -2;
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    y.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.mTR != null) {
      paramViewGroup.removeView(((g.b)this.mTR.get(paramInt)).bQf);
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mTR != null)
    {
      y.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((g.b)this.mTR.get(paramInt)).bQf, 0);
      return ((g.b)this.mTR.get(paramInt)).bQf;
    }
    return super.b(paramViewGroup, paramInt);
  }
  
  public final int getCount()
  {
    if (this.mTv == null) {
      return 0;
    }
    if (this.mTS) {
      return 2147483647;
    }
    return this.mTv.size();
  }
  
  public final void setData(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() > 0) {
        this.mTv = paramList;
      }
      if (this.mTR == null) {
        this.mTR = new ArrayList();
      }
      for (;;)
      {
        paramList = this.mTv.iterator();
        while (paramList.hasNext())
        {
          g.b localb = new g.b(this, (String)paramList.next());
          this.mTR.add(localb);
        }
        this.mTR.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */