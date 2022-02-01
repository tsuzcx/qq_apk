package com.tencent.mm.ui.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.r;

public final class b
  extends r
{
  public long mDuration;
  @SuppressLint({"HandlerLeak"})
  private MMHandler mHandler;
  
  private b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(142861);
    this.mDuration = 3000L;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142860);
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(142860);
          return;
        }
        b.this.dismiss();
        AppMethodBeat.o(142860);
      }
    };
    AppMethodBeat.o(142861);
  }
  
  public static b lx(Context paramContext)
  {
    AppMethodBeat.i(142862);
    paramContext = LayoutInflater.from(paramContext).inflate(a.h.toast_popup, null);
    ((TextView)paramContext.findViewById(a.g.toast_text)).setVisibility(8);
    b localb = new b(paramContext);
    localb.setFocusable(false);
    localb.setContentView(paramContext);
    localb.setWidth(-1);
    localb.setHeight(-1);
    localb.setAnimationStyle(a.l.ToastPopupWindow);
    localb.mDuration = 1200L;
    AppMethodBeat.o(142862);
    return localb;
  }
  
  public final void showAsDropDown(View paramView)
  {
    AppMethodBeat.i(142864);
    super.showAsDropDown(paramView);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(142864);
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142863);
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(142863);
  }
  
  public final void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142865);
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    AppMethodBeat.o(142865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.j.b
 * JD-Core Version:    0.7.0.1
 */