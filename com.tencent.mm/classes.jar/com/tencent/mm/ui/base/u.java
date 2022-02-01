package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class u
  extends q
{
  public Queue<View> JJF = new LinkedList();
  public HashMap<Object, Integer> JJG = new HashMap();
  public SparseArray<Object> JJH = new SparseArray();
  
  public abstract MultiTouchImageView HN(int paramInt);
  
  public abstract WxImageView HO(int paramInt);
  
  public final View Tq(int paramInt)
  {
    Object localObject = this.JJH.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ae.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    ae.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.JJF.add((View)paramObject);
    this.JJG.remove(paramObject);
    this.JJH.remove(paramInt);
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
    if (this.JJG.containsKey(paramObject)) {
      return ((Integer)this.JJG.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.JJF.size() > 0) {
      localObject = (View)this.JJF.poll();
    }
    localObject = g(paramInt, (View)localObject);
    ae.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.JJG.put(localObject, Integer.valueOf(paramInt));
    this.JJH.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    ae.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    this.JJF.clear();
    this.JJG.clear();
    this.JJH.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.u
 * JD-Core Version:    0.7.0.1
 */