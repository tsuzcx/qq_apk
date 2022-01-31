package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public final class g
{
  public View mParentView;
  public PopupWindow rHY;
  public g.a rHZ;
  
  public g(Context paramContext, View paramView)
  {
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.wenote_editor_operate_window, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.rHY = new PopupWindow(paramContext, -2, -2, false);
    this.rHY.setClippingEnabled(false);
    paramContext.findViewById(R.h.wenote_delete_tv).setOnClickListener(new g.1(this));
    paramContext.findViewById(R.h.wenote_copy_tv).setOnClickListener(new g.2(this));
    paramContext.findViewById(R.h.wenote_cut_tv).setOnClickListener(new g.3(this));
    paramContext.findViewById(R.h.wenote_paste_tv).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        g.this.rHY.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.rHZ != null) {
          g.this.rHZ.ciq();
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */