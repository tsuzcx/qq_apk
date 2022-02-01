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
  protected int JGU;
  protected Context context;
  protected int count;
  protected ImageView dtJ;
  protected Map<Integer, ImageView> map;
  
  public MMPageControlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142054);
    this.map = new HashMap();
    this.JGU = 2131494916;
    this.context = paramContext;
    AppMethodBeat.o(142054);
  }
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142055);
    this.map = new HashMap();
    this.JGU = 2131494916;
    this.context = paramContext;
    AppMethodBeat.o(142055);
  }
  
  protected void Rc(int paramInt)
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
      this.dtJ = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.dtJ = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dtJ == null)
        {
          this.dtJ = ((ImageView)View.inflate(this.context, this.JGU, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dtJ);
        }
        this.dtJ.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.dtJ.setPadding(0, 0, 0, 0);
        }
        addView(this.dtJ);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.dtJ = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dtJ == null)
        {
          this.dtJ = ((ImageView)View.inflate(this.context, this.JGU, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dtJ);
        }
        this.dtJ.setSelected(false);
      }
    }
    AppMethodBeat.o(142056);
  }
  
  public final void jO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142052);
    this.count = paramInt1;
    Rc(paramInt2);
    AppMethodBeat.o(142052);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.JGU = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(142053);
    Rc(paramInt);
    AppMethodBeat.o(142053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */