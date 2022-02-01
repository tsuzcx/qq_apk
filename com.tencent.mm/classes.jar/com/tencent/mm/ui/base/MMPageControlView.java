package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView
  extends LinearLayout
{
  protected int adSt;
  protected Context context;
  protected int count;
  protected ImageView hIz;
  protected Map<Integer, ImageView> map;
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142055);
    this.map = new HashMap();
    this.adSt = a.h.mmpage_control_image;
    this.context = paramContext;
    AppMethodBeat.o(142055);
  }
  
  protected void ali(int paramInt)
  {
    AppMethodBeat.i(142056);
    removeAllViews();
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(142056);
      return;
    }
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.hIz = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.hIz = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.hIz == null)
        {
          this.hIz = ((ImageView)View.inflate(this.context, this.adSt, null).findViewById(a.g.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.hIz);
        }
        this.hIz.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.hIz.setPadding(0, 0, 0, 0);
        }
        addView(this.hIz);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.hIz = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.hIz == null)
        {
          this.hIz = ((ImageView)View.inflate(this.context, this.adSt, null).findViewById(a.g.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.hIz);
        }
        this.hIz.setSelected(false);
      }
    }
    AppMethodBeat.o(142056);
  }
  
  public final void oj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142052);
    this.count = paramInt1;
    ali(paramInt2);
    AppMethodBeat.o(142052);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.adSt = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(142053);
    ali(paramInt);
    AppMethodBeat.o(142053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */