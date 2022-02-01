package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends q
{
  private Queue<View> ONZ;
  private int OOa = 0;
  public Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.ONZ = new LinkedList();
  }
  
  public abstract void Te(int paramInt);
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.ONZ.add(paramObject);
    Te(paramInt);
    Log.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.ONZ.size()) });
  }
  
  public abstract int evg();
  
  public int getItemPosition(Object paramObject)
  {
    if (this.OOa > 0)
    {
      this.OOa -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.ONZ.poll(), paramViewGroup, paramInt);
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramViewGroup.addView(localView);
    Log.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.OOa = evg();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */