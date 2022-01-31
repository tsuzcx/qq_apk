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
  protected Context context;
  protected int count;
  protected ImageView cuM;
  protected Map<Integer, ImageView> map;
  protected int zlb;
  
  public MMPageControlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(106701);
    this.map = new HashMap();
    this.zlb = 2130970284;
    this.context = paramContext;
    AppMethodBeat.o(106701);
  }
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106702);
    this.map = new HashMap();
    this.zlb = 2130970284;
    this.context = paramContext;
    AppMethodBeat.o(106702);
  }
  
  protected void Eg(int paramInt)
  {
    AppMethodBeat.i(106703);
    removeAllViews();
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(106703);
      return;
    }
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.cuM = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.cuM = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.cuM == null)
        {
          this.cuM = ((ImageView)View.inflate(this.context, this.zlb, null).findViewById(2131826286));
          this.map.put(Integer.valueOf(i), this.cuM);
        }
        this.cuM.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.cuM.setPadding(0, 0, 0, 0);
        }
        addView(this.cuM);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.cuM = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.cuM == null)
        {
          this.cuM = ((ImageView)View.inflate(this.context, this.zlb, null).findViewById(2131826286));
          this.map.put(Integer.valueOf(i), this.cuM);
        }
        this.cuM.setSelected(false);
      }
    }
    AppMethodBeat.o(106703);
  }
  
  public final void hy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106699);
    this.count = paramInt1;
    Eg(paramInt2);
    AppMethodBeat.o(106699);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.zlb = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(106700);
    Eg(paramInt);
    AppMethodBeat.o(106700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */