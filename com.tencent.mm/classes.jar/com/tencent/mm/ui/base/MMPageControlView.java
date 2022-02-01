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
  protected int WkZ;
  protected Context context;
  protected int count;
  protected ImageView fDJ;
  protected Map<Integer, ImageView> map;
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142055);
    this.map = new HashMap();
    this.WkZ = a.h.mmpage_control_image;
    this.context = paramContext;
    AppMethodBeat.o(142055);
  }
  
  protected void agq(int paramInt)
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
      this.fDJ = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.fDJ = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.fDJ == null)
        {
          this.fDJ = ((ImageView)View.inflate(this.context, this.WkZ, null).findViewById(a.g.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.fDJ);
        }
        this.fDJ.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.fDJ.setPadding(0, 0, 0, 0);
        }
        addView(this.fDJ);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.fDJ = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.fDJ == null)
        {
          this.fDJ = ((ImageView)View.inflate(this.context, this.WkZ, null).findViewById(a.g.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.fDJ);
        }
        this.fDJ.setSelected(false);
      }
    }
    AppMethodBeat.o(142056);
  }
  
  public final void mp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142052);
    this.count = paramInt1;
    agq(paramInt2);
    AppMethodBeat.o(142052);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.WkZ = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(142053);
    agq(paramInt);
    AppMethodBeat.o(142053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */