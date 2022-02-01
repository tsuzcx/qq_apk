package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

public class o
  extends PopupWindow
{
  private View.OnTouchListener JGV;
  private Context mContext;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159247);
    this.mContext = null;
    this.mContext = paramContext;
    super.setBackgroundDrawable(null);
    setContentView(new o.a(this, this.mContext));
    AppMethodBeat.o(159247);
  }
  
  public o(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(159248);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159248);
  }
  
  public o(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    AppMethodBeat.i(159249);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159249);
  }
  
  public o(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.i(159250);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159250);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159251);
    try
    {
      super.dismiss();
      AppMethodBeat.o(159251);
      return;
    }
    catch (Exception localException)
    {
      ap.e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(159251);
    }
  }
  
  public Drawable getBackground()
  {
    AppMethodBeat.i(159252);
    Object localObject = getContentView();
    if (localObject == null)
    {
      AppMethodBeat.o(159252);
      return null;
    }
    if ((localObject instanceof o.a))
    {
      localObject = ((View)localObject).getBackground();
      AppMethodBeat.o(159252);
      return localObject;
    }
    AppMethodBeat.o(159252);
    return null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    int i = -2;
    AppMethodBeat.i(159254);
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(159254);
      return;
    }
    Object localObject1 = localView.getContext();
    if ((localView instanceof o.a))
    {
      localView.setBackgroundDrawable(paramDrawable);
      AppMethodBeat.o(159254);
      return;
    }
    Object localObject2 = localView.getLayoutParams();
    if ((localObject2 != null) && (((ViewGroup.LayoutParams)localObject2).height == -2)) {}
    for (;;)
    {
      localObject1 = new o.a(this, (Context)localObject1);
      localObject2 = new FrameLayout.LayoutParams(-1, i);
      ((o.a)localObject1).setBackgroundDrawable(paramDrawable);
      ((o.a)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
      super.setContentView((View)localObject1);
      AppMethodBeat.o(159254);
      return;
      i = -1;
    }
  }
  
  public void setContentView(View paramView)
  {
    int i = -2;
    AppMethodBeat.i(159253);
    Object localObject = getContentView();
    if (localObject == null) {
      super.setContentView(paramView);
    }
    while (!(localObject instanceof o.a))
    {
      super.setContentView(paramView);
      AppMethodBeat.o(159253);
      return;
    }
    localObject = (o.a)localObject;
    ((o.a)localObject).removeAllViews();
    if (paramView == null)
    {
      super.setContentView((View)localObject);
      AppMethodBeat.o(159253);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height == -2)) {}
    for (;;)
    {
      ((o.a)localObject).addView(paramView, new FrameLayout.LayoutParams(-1, i));
      super.setContentView((View)localObject);
      AppMethodBeat.o(159253);
      return;
      i = -1;
    }
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.JGV = paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.o
 * JD-Core Version:    0.7.0.1
 */