package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView
  extends LinearLayout
{
  protected int ORM;
  protected Context context;
  protected int count;
  protected ImageView dKU;
  protected Map<Integer, ImageView> map;
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142055);
    this.map = new HashMap();
    this.ORM = 2131495656;
    this.context = paramContext;
    AppMethodBeat.o(142055);
  }
  
  protected void Za(int paramInt)
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
      this.dKU = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.dKU = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dKU == null)
        {
          this.dKU = ((ImageView)View.inflate(this.context, this.ORM, null).findViewById(2131304738));
          this.map.put(Integer.valueOf(i), this.dKU);
        }
        this.dKU.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.dKU.setPadding(0, 0, 0, 0);
        }
        addView(this.dKU);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.dKU = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dKU == null)
        {
          this.dKU = ((ImageView)View.inflate(this.context, this.ORM, null).findViewById(2131304738));
          this.map.put(Integer.valueOf(i), this.dKU);
        }
        this.dKU.setSelected(false);
      }
    }
    AppMethodBeat.o(142056);
  }
  
  public final void kX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142052);
    this.count = paramInt1;
    Za(paramInt2);
    AppMethodBeat.o(142052);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.ORM = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(142053);
    Za(paramInt);
    AppMethodBeat.o(142053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */