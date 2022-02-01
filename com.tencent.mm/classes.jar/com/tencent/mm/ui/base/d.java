package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d
  extends a
{
  private Queue<View> adOg;
  private int adOh = 0;
  public Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.adOg = new LinkedList();
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, int paramInt);
  
  public abstract int bZC();
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.adOg.add(paramObject);
    yG(paramInt);
    Log.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[] { Integer.valueOf(this.adOg.size()) });
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.adOh > 0)
    {
      this.adOh -= 1;
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    View localView = a((View)this.adOg.poll(), paramViewGroup, paramInt);
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
    this.adOh = bZC();
    super.notifyDataSetChanged();
  }
  
  public abstract void yG(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.d
 * JD-Core Version:    0.7.0.1
 */