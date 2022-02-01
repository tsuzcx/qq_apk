package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class u
  extends q
{
  public Queue<View> JoQ = new LinkedList();
  public HashMap<Object, Integer> JoR = new HashMap();
  public SparseArray<Object> JoS = new SparseArray();
  
  public abstract MultiTouchImageView Hq(int paramInt);
  
  public abstract WxImageView Hr(int paramInt);
  
  public final View SJ(int paramInt)
  {
    Object localObject = this.JoS.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ad.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    ad.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.JoQ.add((View)paramObject);
    this.JoR.remove(paramObject);
    this.JoS.remove(paramInt);
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
    if (this.JoR.containsKey(paramObject)) {
      return ((Integer)this.JoR.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.JoQ.size() > 0) {
      localObject = (View)this.JoQ.poll();
    }
    localObject = g(paramInt, (View)localObject);
    ad.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.JoR.put(localObject, Integer.valueOf(paramInt));
    this.JoS.put(paramInt, localObject);
    if (((View)localObject).getParent() == null) {
      paramViewGroup.addView((View)localObject);
    }
    ad.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    this.JoQ.clear();
    this.JoR.clear();
    this.JoS.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.u
 * JD-Core Version:    0.7.0.1
 */