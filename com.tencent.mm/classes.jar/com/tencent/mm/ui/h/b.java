package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

public final class b
  extends o
{
  public long mDuration;
  @SuppressLint({"HandlerLeak"})
  private ak mHandler;
  
  private b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(107427);
    this.mDuration = 3000L;
    this.mHandler = new b.1(this);
    AppMethodBeat.o(107427);
  }
  
  public static b iz(Context paramContext)
  {
    AppMethodBeat.i(107428);
    paramContext = LayoutInflater.from(paramContext).inflate(2130971003, null);
    ((TextView)paramContext.findViewById(2131822417)).setVisibility(8);
    b localb = new b(paramContext);
    localb.setFocusable(false);
    localb.setContentView(paramContext);
    localb.setWidth(-1);
    localb.setHeight(-1);
    localb.setAnimationStyle(2131493692);
    localb.mDuration = 1200L;
    AppMethodBeat.o(107428);
    return localb;
  }
  
  public final void showAsDropDown(View paramView)
  {
    AppMethodBeat.i(107430);
    super.showAsDropDown(paramView);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(107430);
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107429);
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(107429);
  }
  
  public final void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107431);
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(107431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h.b
 * JD-Core Version:    0.7.0.1
 */