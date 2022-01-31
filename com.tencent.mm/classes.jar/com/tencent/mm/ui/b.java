package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private Context mContext;
  private int vYw;
  private boolean yTM;
  private View yTN;
  private int yTO;
  private ViewGroup.LayoutParams yTP;
  private int yTQ;
  
  private b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(105945);
    this.yTM = false;
    this.mContext = paramActivity;
    this.yTM = paramBoolean;
    this.yTN = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.yTN.getViewTreeObserver().addOnGlobalLayoutListener(new b.1(this));
    this.yTP = this.yTN.getLayoutParams();
    AppMethodBeat.o(105945);
  }
  
  private b(Activity paramActivity, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(105946);
    this.yTM = false;
    this.mContext = paramActivity;
    this.yTM = paramBoolean;
    this.yTN = paramView;
    this.yTN.getViewTreeObserver().addOnGlobalLayoutListener(new b.2(this));
    this.yTP = this.yTN.getLayoutParams();
    AppMethodBeat.o(105946);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(105944);
    new b(paramActivity, paramBoolean, paramView);
    AppMethodBeat.o(105944);
  }
  
  public static void c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(105943);
    new b(paramActivity, paramBoolean);
    AppMethodBeat.o(105943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */