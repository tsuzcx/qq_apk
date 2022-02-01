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
import com.tencent.mm.ui.ar;

public class PatPopupWindow
  extends PopupWindow
{
  private FrameLayout GKQ;
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
    AppMethodBeat.i(186435);
    this.GKQ = new FrameLayout(paramContext);
    super.setContentView(this.GKQ);
    AppMethodBeat.o(186435);
  }
  
  public PatPopupWindow(View paramView)
  {
    this(paramView.getContext());
    AppMethodBeat.i(186436);
    this.GKQ = new FrameLayout(paramView.getContext());
    super.setContentView(this.GKQ);
    setContentView(paramView);
    AppMethodBeat.o(186436);
  }
  
  private void fI(View paramView)
  {
    AppMethodBeat.i(186442);
    int i = ar.hIP().widthPixels;
    int j = ar.hIP().heightPixels;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    setWidth(-2);
    setHeight(-2);
    this.maxWidth = i;
    this.maxHeight = arrayOfInt[1];
    this.GKQ.measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, View.MeasureSpec.getMode(-2147483648)), View.MeasureSpec.makeMeasureSpec(this.maxHeight, View.MeasureSpec.getMode(-2147483648)));
    setWidth(Math.min(this.GKQ.getMeasuredWidth(), this.maxWidth));
    setHeight(Math.min(this.GKQ.getMeasuredHeight(), this.maxHeight));
    AppMethodBeat.o(186442);
  }
  
  private void fJ(View paramView)
  {
    AppMethodBeat.i(186444);
    paramView.getLocationInWindow(new int[2]);
    this.x = 0;
    this.y = 0;
    this.x = (-(this.GKQ.getMeasuredWidth() - paramView.getWidth()) / 2);
    this.y = (-this.GKQ.getMeasuredHeight() - paramView.getHeight());
    AppMethodBeat.o(186444);
  }
  
  public final void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186440);
    if (getBackground() == null) {
      setBackgroundDrawable(new ColorDrawable(0));
    }
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(186440);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramLayoutParams.leftMargin;
    localLayoutParams.rightMargin = paramLayoutParams.rightMargin;
    localLayoutParams.topMargin = paramLayoutParams.topMargin;
    localLayoutParams.bottomMargin = paramLayoutParams.bottomMargin;
    localView.setLayoutParams(localLayoutParams);
    fI(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show contentView size (%d,%d)", new Object[] { Integer.valueOf(this.GKQ.getMeasuredWidth()), Integer.valueOf(this.GKQ.getMeasuredHeight()) });
    fJ(paramView);
    Log.d("MicroMsg.PatPopupWindow", "show at fix location (%d,%d)", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y) });
    if (isShowing())
    {
      update(paramView, this.x, this.y, getWidth(), getHeight());
      AppMethodBeat.o(186440);
      return;
    }
    showAsDropDown(paramView, this.x, this.y);
    AppMethodBeat.o(186440);
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(186438);
    View localView = this.GKQ.getChildAt(0);
    AppMethodBeat.o(186438);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(186437);
    this.GKQ.removeAllViews();
    this.GKQ.addView(paramView);
    AppMethodBeat.o(186437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatPopupWindow
 * JD-Core Version:    0.7.0.1
 */