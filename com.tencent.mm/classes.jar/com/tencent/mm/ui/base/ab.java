package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class ab
  extends a
{
  public Queue<View> adVa = new LinkedList();
  public HashMap<Object, Integer> adVb = new HashMap();
  public SparseArray<Object> adVc = new SparseArray();
  
  public abstract MultiTouchImageView WN(int paramInt);
  
  public abstract WxImageView WO(int paramInt);
  
  public final View aAZ(int paramInt)
  {
    Object localObject = this.adVc.get(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Log.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[] { Integer.valueOf(paramInt) });
    Log.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[] { Integer.valueOf(paramObject.hashCode()) });
    this.adVa.add((View)paramObject);
    this.adVb.remove(paramObject);
    this.adVc.remove(paramInt);
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
    if (this.adVb.containsKey(paramObject)) {
      return ((Integer)this.adVb.get(paramObject)).intValue();
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    if (this.adVa.size() > 0) {
      localObject = (View)this.adVa.poll();
    }
    localObject = p(paramInt, (View)localObject);
    Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", new Object[] { Integer.valueOf(localObject.hashCode()), ((View)localObject).getParent(), Integer.valueOf(paramInt) });
    this.adVb.put(localObject, Integer.valueOf(paramInt));
    this.adVc.put(paramInt, localObject);
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
  
  public abstract Object p(int paramInt, View paramView);
  
  public final void reset()
  {
    this.adVa.clear();
    this.adVb.clear();
    this.adVc.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.ab
 * JD-Core Version:    0.7.0.1
 */