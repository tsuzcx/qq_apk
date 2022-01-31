package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView
  extends LinearLayout
{
  public ImageView bNu;
  public Context context;
  public int count;
  public Map<Integer, ImageView> map = new HashMap();
  public int uWI = a.h.mmpage_control_image;
  
  public MMPageControlView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    this.count = paramInt1;
    yh(paramInt2);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.uWI = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    yh(paramInt);
  }
  
  public void yh(int paramInt)
  {
    removeAllViews();
    if (paramInt >= this.count) {
      return;
    }
    int j = this.count;
    int i = 0;
    label20:
    if (i < j)
    {
      this.bNu = null;
      if (paramInt != i) {
        break label156;
      }
      if (this.map.size() > i) {
        this.bNu = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.bNu == null)
      {
        this.bNu = ((ImageView)View.inflate(this.context, this.uWI, null).findViewById(a.g.mmpage_control_img));
        this.map.put(Integer.valueOf(i), this.bNu);
      }
      this.bNu.setSelected(true);
    }
    for (;;)
    {
      if (i == 0) {
        this.bNu.setPadding(0, 0, 0, 0);
      }
      addView(this.bNu);
      i += 1;
      break label20;
      break;
      label156:
      if (this.map.size() > i) {
        this.bNu = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.bNu == null)
      {
        this.bNu = ((ImageView)View.inflate(this.context, this.uWI, null).findViewById(a.g.mmpage_control_img));
        this.map.put(Integer.valueOf(i), this.bNu);
      }
      this.bNu.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */