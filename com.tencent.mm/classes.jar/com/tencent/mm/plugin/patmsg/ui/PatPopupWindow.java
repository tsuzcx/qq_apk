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
import com.tencent.mm.ui.ao;

public class PatPopupWindow
  extends PopupWindow
{
  private FrameLayout ARF;
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
    AppMethodBeat.i(207004);
    this.ARF = new FrameLayout(paramContext);
    super.setContentView(this.ARF);
    AppMethodBeat.o(207004);
  }
  
  public PatPopupWindow(View paramView)
  {
    this(paramView.getContext());
    AppMethodBeat.i(207005);
    this.ARF = new FrameLayout(paramView.getContext());
    super.setContentView(this.ARF);
    setContentView(paramView);
    AppMethodBeat.o(207005);
  }
  
  private void eG(View paramView)
  {
    AppMethodBeat.i(207009);
    int i = ao.gJO().widthPixels;
    int j = ao.gJO().heightPixels;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    setWidth(-2);
    setHeight(-2);
    this.maxWidth = i;
    this.maxHeight = arrayOfInt[1];
    this.ARF.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(-2147483648)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(-2147483648)));
    setWidth(Math.min(this.ARF.getMeasuredWidth(), this.maxWidth));
    setHeight(Math.min(this.ARF.getMeasuredHeight(), this.maxHeight));
    AppMethodBeat.o(207009);
  }
  
  private void eH(View paramView)
  {
    AppMethodBeat.i(207010);
    paramView.getLocationInWindow(new int[2]);
    this.x = 0;
    this.y = 0;
    this.x = (-(this.ARF.getMeasuredWidth() - paramView.getWidth()) / 2);
    this.y = (-this.ARF.getMeasuredHeight() - paramView.getHeight());
    AppMethodBeat.o(207010);
  }
  
  public final void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207008);
    if (getBackground() == null) {
      setBackgroundDrawable(new ColorDrawable(0));
    }
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(207008);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramLayoutParams.leftMargin;
    localLayoutParams.rightMargin = paramLayoutParams.rightMargin;
    localLayoutParams.topMargin = paramLayoutParams.topMargin;
    localLayoutParams.bottomMargin = paramLayoutParams.bottomMargin;
    localView.setLayoutParams(localLayoutParams);
    eG(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", new Object[] { Integer.valueOf(this.ARF.getMeasuredWidth()), Integer.valueOf(this.ARF.getMeasuredHeight()) });
    eH(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y) });
    if (isShowing())
    {
      update(paramView, this.x, this.y, getWidth(), getHeight());
      AppMethodBeat.o(207008);
      return;
    }
    showAsDropDown(paramView, this.x, this.y);
    AppMethodBeat.o(207008);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(207007);
    View localView = this.ARF.getChildAt(0);
    AppMethodBeat.o(207007);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(207006);
    this.ARF.removeAllViews();
    this.ARF.addView(paramView);
    AppMethodBeat.o(207006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatPopupWindow
 * JD-Core Version:    0.7.0.1
 */