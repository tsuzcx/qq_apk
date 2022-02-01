package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;

public class PatPopupWindow
  extends PopupWindow
{
  private FrameLayout MHK;
  private int maxHeight;
  private int maxWidth;
  private int x;
  private int y;
  
  private PatPopupWindow(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PatPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public PatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266381);
    this.MHK = new FrameLayout(paramContext);
    super.setContentView(this.MHK);
    AppMethodBeat.o(266381);
  }
  
  public PatPopupWindow(View paramView)
  {
    this(paramView.getContext());
    AppMethodBeat.i(266391);
    this.MHK = new FrameLayout(paramView.getContext());
    super.setContentView(this.MHK);
    setContentView(paramView);
    AppMethodBeat.o(266391);
  }
  
  private void iB(View paramView)
  {
    AppMethodBeat.i(266399);
    int i = aw.jld().widthPixels;
    int j = aw.jld().heightPixels;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    setWidth(-2);
    setHeight(-2);
    this.maxWidth = i;
    this.maxHeight = arrayOfInt[1];
    this.MHK.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(-2147483648)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(-2147483648)));
    setWidth(Math.min(this.MHK.getMeasuredWidth(), this.maxWidth));
    setHeight(Math.min(this.MHK.getMeasuredHeight(), this.maxHeight));
    AppMethodBeat.o(266399);
  }
  
  private void iC(View paramView)
  {
    AppMethodBeat.i(266407);
    paramView.getLocationInWindow(new int[2]);
    this.x = 0;
    this.y = 0;
    this.x = (-(this.MHK.getMeasuredWidth() - paramView.getWidth()) / 2);
    this.y = (-this.MHK.getMeasuredHeight() - paramView.getHeight());
    AppMethodBeat.o(266407);
  }
  
  public final void b(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(266428);
    if (getBackground() == null) {
      setBackgroundDrawable(new ColorDrawable(0));
    }
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(266428);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramLayoutParams.leftMargin;
    localLayoutParams.rightMargin = paramLayoutParams.rightMargin;
    localLayoutParams.topMargin = paramLayoutParams.topMargin;
    localLayoutParams.bottomMargin = paramLayoutParams.bottomMargin;
    localView.setLayoutParams(localLayoutParams);
    iB(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", new Object[] { Integer.valueOf(this.MHK.getMeasuredWidth()), Integer.valueOf(this.MHK.getMeasuredHeight()) });
    iC(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y) });
    if (isShowing())
    {
      update(paramView, this.x, this.y, getWidth(), getHeight());
      AppMethodBeat.o(266428);
      return;
    }
    showAsDropDown(paramView, this.x, this.y);
    AppMethodBeat.o(266428);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(266422);
    View localView = this.MHK.getChildAt(0);
    AppMethodBeat.o(266422);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(266412);
    this.MHK.removeAllViews();
    this.MHK.addView(paramView);
    AppMethodBeat.o(266412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatPopupWindow
 * JD-Core Version:    0.7.0.1
 */