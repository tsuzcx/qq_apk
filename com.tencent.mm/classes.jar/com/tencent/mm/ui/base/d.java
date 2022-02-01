package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends q
{
  private Queue<View> HuD;
  private int HuE = 0;
  public Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.HuD = new LinkedList();
  }
  
  public abstract void Ka(int paramInt);
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.HuD.add(paramObject);
    Ka(paramInt);
    ac.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.HuD.size()) });
  }
  
  public abstract int djx();
  
  public int getItemPosition(Object paramObject)
  {
    if (this.HuE > 0)
    {
      this.HuE -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.HuD.poll(), paramViewGroup, paramInt);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramViewGroup.addView(localView);
    ac.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.HuE = djx();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */