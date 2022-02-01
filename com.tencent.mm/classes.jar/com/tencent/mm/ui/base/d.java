package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends q
{
  private Queue<View> Jit;
  private int Jiu = 0;
  public Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.Jit = new LinkedList();
  }
  
  public abstract void LC(int paramInt);
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.Jit.add(paramObject);
    LC(paramInt);
    ad.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.Jit.size()) });
  }
  
  public abstract int dtJ();
  
  public int getItemPosition(Object paramObject)
  {
    if (this.Jiu > 0)
    {
      this.Jiu -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.Jit.poll(), paramViewGroup, paramInt);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramViewGroup.addView(localView);
    ad.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.Jiu = dtJ();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */