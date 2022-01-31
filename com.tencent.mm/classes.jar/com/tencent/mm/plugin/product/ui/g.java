package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
{
  Context mContext;
  private List<String> pvB;
  private ArrayList<g.b> pvX;
  private boolean pvY;
  g.a pvZ;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(44073);
    this.pvY = false;
    this.pvZ = null;
    this.mContext = paramContext;
    this.pvB = null;
    setData(this.pvB);
    AppMethodBeat.o(44073);
  }
  
  private void cbv()
  {
    AppMethodBeat.i(44074);
    if (this.pvX == null) {
      this.pvX = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.pvB.iterator();
      while (localIterator.hasNext())
      {
        g.b localb = new g.b(this, (String)localIterator.next());
        this.pvX.add(localb);
      }
      this.pvX.clear();
    }
    AppMethodBeat.o(44074);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(44077);
    ab.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.pvX != null) {
      paramViewGroup.removeView(((g.b)this.pvX.get(paramInt)).cxy);
    }
    AppMethodBeat.o(44077);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44076);
    if (this.pvB == null)
    {
      AppMethodBeat.o(44076);
      return 0;
    }
    if (this.pvY)
    {
      AppMethodBeat.o(44076);
      return 2147483647;
    }
    int i = this.pvB.size();
    AppMethodBeat.o(44076);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(44078);
    if (this.pvX != null)
    {
      ab.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((g.b)this.pvX.get(paramInt)).cxy, 0);
      paramViewGroup = ((g.b)this.pvX.get(paramInt)).cxy;
      AppMethodBeat.o(44078);
      return paramViewGroup;
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(44078);
    return paramViewGroup;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void setData(List<String> paramList)
  {
    AppMethodBeat.i(44075);
    if (paramList != null)
    {
      if (paramList.size() > 0) {
        this.pvB = paramList;
      }
      cbv();
    }
    AppMethodBeat.o(44075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */