package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class u
  extends q
{
  public Queue<View> HAZ = new LinkedList();
  public HashMap<Object, Integer> HBa = new HashMap();
  public SparseArray<Object> HBb = new SparseArray();
  
  public abstract MultiTouchImageView Gb(int paramInt);
  
  public abstract WxImageView Gc(int paramInt);
  
  public final View QZ(int paramInt)
  {
    Object localObject = this.HBb.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ac.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    ac.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.HAZ.add((View)paramObject);
    this.HBa.remove(paramObject);
    this.HBb.remove(paramInt);
  }
  
  public void detach()
  {
    reset();
  }
  
  public int firstItemPosForDetermine()
  {
    return -1;
  }
  
  public abstract Object g(int paramInt, View paramView);
  
  public int getItemPosition(Object paramObject)
  {
    if (this.HBa.containsKey(paramObject)) {
      return ((Integer)this.HBa.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.HAZ.size() > 0) {
      localObject = (View)this.HAZ.poll();
    }
    localObject = g(paramInt, (View)localObject);
    ac.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.HBa.put(localObject, Integer.valueOf(paramInt));
    this.HBb.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    ac.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    this.HAZ.clear();
    this.HBa.clear();
    this.HBb.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.u
 * JD-Core Version:    0.7.0.1
 */