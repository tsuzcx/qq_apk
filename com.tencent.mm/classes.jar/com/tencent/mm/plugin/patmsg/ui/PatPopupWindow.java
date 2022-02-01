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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;

public class PatPopupWindow
  extends PopupWindow
{
  private int maxHeight;
  private int maxWidth;
  private FrameLayout wGa;
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
    AppMethodBeat.i(215749);
    this.wGa = new FrameLayout(paramContext);
    super.setContentView(this.wGa);
    AppMethodBeat.o(215749);
  }
  
  public PatPopupWindow(View paramView)
  {
    this(paramView.getContext());
    AppMethodBeat.i(215750);
    this.wGa = new FrameLayout(paramView.getContext());
    super.setContentView(this.wGa);
    setContentView(paramView);
    AppMethodBeat.o(215750);
  }
  
  private void ey(View paramView)
  {
    AppMethodBeat.i(215754);
    int i = al.fxO().widthPixels;
    int j = al.fxO().heightPixels;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    setWidth(-2);
    setHeight(-2);
    this.maxWidth = i;
    this.maxHeight = arrayOfInt[1];
    this.wGa.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(-2147483648)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(-2147483648)));
    setWidth(Math.min(this.wGa.getMeasuredWidth(), this.maxWidth));
    setHeight(Math.min(this.wGa.getMeasuredHeight(), this.maxHeight));
    AppMethodBeat.o(215754);
  }
  
  private void ez(View paramView)
  {
    AppMethodBeat.i(215755);
    paramView.getLocationInWindow(new int[2]);
    this.x = 0;
    this.y = 0;
    this.x = (-(this.wGa.getMeasuredWidth() - paramView.getWidth()) / 2);
    this.y = (-this.wGa.getMeasuredHeight() - paramView.getHeight());
    AppMethodBeat.o(215755);
  }
  
  public final void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(215753);
    if (getBackground() == null) {
      setBackgroundDrawable(new ColorDrawable(0));
    }
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(215753);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramLayoutParams.leftMargin;
    localLayoutParams.rightMargin = paramLayoutParams.rightMargin;
    localLayoutParams.topMargin = paramLayoutParams.topMargin;
    localLayoutParams.bottomMargin = paramLayoutParams.bottomMargin;
    localView.setLayoutParams(localLayoutParams);
    ey(paramView);
    ad.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", new Object[] { Integer.valueOf(this.wGa.getMeasuredWidth()), Integer.valueOf(this.wGa.getMeasuredHeight()) });
    ez(paramView);
    ad.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y) });
    if (isShowing())
    {
      update(paramView, this.x, this.y, getWidth(), getHeight());
      AppMethodBeat.o(215753);
      return;
    }
    showAsDropDown(paramView, this.x, this.y);
    AppMethodBeat.o(215753);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(215752);
    View localView = this.wGa.getChildAt(0);
    AppMethodBeat.o(215752);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(215751);
    this.wGa.removeAllViews();
    this.wGa.addView(paramView);
    AppMethodBeat.o(215751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatPopupWindow
 * JD-Core Version:    0.7.0.1
 */