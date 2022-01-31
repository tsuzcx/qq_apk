package com.tencent.mm.ui.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.o;

public final class b
  extends o
{
  public long mDuration = 3000L;
  @SuppressLint({"HandlerLeak"})
  private ah mHandler = new b.1(this);
  
  private b(View paramView)
  {
    super(paramView);
  }
  
  public static b hd(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.h.toast_popup, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setVisibility(8);
    b localb = new b(paramContext);
    localb.setFocusable(false);
    localb.setContentView(paramContext);
    localb.setWidth(-1);
    localb.setHeight(-1);
    localb.setAnimationStyle(a.l.ToastPopupWindow);
    localb.mDuration = 1200L;
    return localb;
  }
  
  public final void showAsDropDown(View paramView)
  {
    super.showAsDropDown(paramView);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
  }
  
  public final void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g.b
 * JD-Core Version:    0.7.0.1
 */