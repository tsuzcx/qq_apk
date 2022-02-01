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
  protected int Hyp;
  protected Context context;
  protected int count;
  protected ImageView dhf;
  protected Map<Integer, ImageView> map;
  
  public MMPageControlView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142054);
    this.map = new HashMap();
    this.Hyp = 2131494916;
    this.context = paramContext;
    AppMethodBeat.o(142054);
  }
  
  public MMPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142055);
    this.map = new HashMap();
    this.Hyp = 2131494916;
    this.context = paramContext;
    AppMethodBeat.o(142055);
  }
  
  protected void ON(int paramInt)
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
      this.dhf = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.dhf = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dhf == null)
        {
          this.dhf = ((ImageView)View.inflate(this.context, this.Hyp, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dhf);
        }
        this.dhf.setSelected(true);
      }
      for (;;)
      {
        if (i == 0) {
          this.dhf.setPadding(0, 0, 0, 0);
        }
        addView(this.dhf);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.dhf = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dhf == null)
        {
          this.dhf = ((ImageView)View.inflate(this.context, this.Hyp, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dhf);
        }
        this.dhf.setSelected(false);
      }
    }
    AppMethodBeat.o(142056);
  }
  
  public final void jy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142052);
    this.count = paramInt1;
    ON(paramInt2);
    AppMethodBeat.o(142052);
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.Hyp = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    AppMethodBeat.i(142053);
    ON(paramInt);
    AppMethodBeat.o(142053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPageControlView
 * JD-Core Version:    0.7.0.1
 */