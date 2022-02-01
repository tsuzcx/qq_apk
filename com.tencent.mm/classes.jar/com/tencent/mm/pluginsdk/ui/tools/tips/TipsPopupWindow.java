package com.tencent.mm.pluginsdk.ui.tools.tips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class TipsPopupWindow
  extends PopupWindow
{
  public FrameLayout MHK;
  public int maxHeight;
  public int maxWidth;
  public int x;
  public int y;
  
  private TipsPopupWindow(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public TipsPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245592);
    this.MHK = new FrameLayout(paramContext);
    super.setContentView(this.MHK);
    AppMethodBeat.o(245592);
  }
  
  public static TipsPopupWindow iOT()
  {
    AppMethodBeat.i(245594);
    TipsPopupWindow localTipsPopupWindow = new TipsPopupWindow(MMApplicationContext.getContext());
    localTipsPopupWindow.setOutsideTouchable(true);
    localTipsPopupWindow.setAnimationStyle(R.m.PatTipWindowAnimation);
    AppMethodBeat.o(245594);
    return localTipsPopupWindow;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(245600);
    View localView = this.MHK.getChildAt(0);
    AppMethodBeat.o(245600);
    return localView;
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(245597);
    this.MHK.removeAllViews();
    this.MHK.addView(paramView);
    AppMethodBeat.o(245597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.tips.TipsPopupWindow
 * JD-Core Version:    0.7.0.1
 */