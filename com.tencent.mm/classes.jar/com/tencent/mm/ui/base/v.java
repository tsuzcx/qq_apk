package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class v
  extends q
{
  public SparseArray<Object> OUA = new SparseArray();
  public Queue<View> OUy = new LinkedList();
  public HashMap<Object, Integer> OUz = new HashMap();
  
  public abstract MultiTouchImageView NQ(int paramInt);
  
  public abstract WxImageView NR(int paramInt);
  
  public final View abm(int paramInt)
  {
    Object localObject = this.OUA.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Log.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    Log.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.OUy.add((View)paramObject);
    this.OUz.remove(paramObject);
    this.OUA.remove(paramInt);
  }
  
  public void detach()
  {
    reset();
  }
  
  public int firstItemPosForDetermine()
  {
    return -1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.OUz.containsKey(paramObject)) {
      return ((Integer)this.OUz.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public abstract Object h(int paramInt, View paramView);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.OUy.size() > 0) {
      localObject = (View)this.OUy.poll();
    }
    localObject = h(paramInt, (View)localObject);
    Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.OUz.put(localObject, Integer.valueOf(paramInt));
    this.OUA.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public int lastItemPosForDetermine()
  {
    return -1;
  }
  
  public final void reset()
  {
    this.OUy.clear();
    this.OUz.clear();
    this.OUA.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.v
 * JD-Core Version:    0.7.0.1
 */