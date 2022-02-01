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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;

public class PatPopupWindow
  extends PopupWindow
{
  private int maxHeight;
  private int maxWidth;
  private FrameLayout wVM;
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
    AppMethodBeat.i(220382);
    this.wVM = new FrameLayout(paramContext);
    super.setContentView(this.wVM);
    AppMethodBeat.o(220382);
  }
  
  public PatPopupWindow(View paramView)
  {
    this(paramView.getContext());
    AppMethodBeat.i(220383);
    this.wVM = new FrameLayout(paramView.getContext());
    super.setContentView(this.wVM);
    setContentView(paramView);
    AppMethodBeat.o(220383);
  }
  
  private void ey(View paramView)
  {
    AppMethodBeat.i(220387);
    int i = al.fBQ().widthPixels;
    int j = al.fBQ().heightPixels;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    setWidth(-2);
    setHeight(-2);
    this.maxWidth = i;
    this.maxHeight = arrayOfInt[1];
    this.wVM.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(-2147483648)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(-2147483648)));
    setWidth(Math.min(this.wVM.getMeasuredWidth(), this.maxWidth));
    setHeight(Math.min(this.wVM.getMeasuredHeight(), this.maxHeight));
    AppMethodBeat.o(220387);
  }
  
  private void ez(View paramView)
  {
    AppMethodBeat.i(220388);
    paramView.getLocationInWindow(new int[2]);
    this.x = 0;
    this.y = 0;
    this.x = (-(this.wVM.getMeasuredWidth() - paramView.getWidth()) / 2);
    this.y = (-this.wVM.getMeasuredHeight() - paramView.getHeight());
    AppMethodBeat.o(220388);
  }
  
  public final void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(220386);
    if (getBackground() == null) {
      setBackgroundDrawable(new ColorDrawable(0));
    }
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(220386);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramLayoutParams.leftMargin;
    localLayoutParams.rightMargin = paramLayoutParams.rightMargin;
    localLayoutParams.topMargin = paramLayoutParams.topMargin;
    localLayoutParams.bottomMargin = paramLayoutParams.bottomMargin;
    localView.setLayoutParams(localLayoutParams);
    ey(paramView);
    ae.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", new Object[] { Integer.valueOf(this.wVM.getMeasuredWidth()), Integer.valueOf(this.wVM.getMeasuredHeight()) });
    ez(paramView);
    ae.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y) });
    if (isShowing())
    {
      update(paramView, this.x, this.y, getWidth(), getHeight());
      AppMethodBeat.o(220386);
      return;
    }
    showAsDropDown(paramView, this.x, this.y);
    AppMethodBeat.o(220386);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(220385);
    View localView = this.wVM.getChildAt(0);
    AppMethodBeat.o(220385);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(220384);
    this.wVM.removeAllViews();
    this.wVM.addView(paramView);
    AppMethodBeat.o(220384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatPopupWindow
 * JD-Core Version:    0.7.0.1
 */