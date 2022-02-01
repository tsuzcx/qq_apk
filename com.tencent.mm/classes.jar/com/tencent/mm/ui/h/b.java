package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.o;

public final class b
  extends o
{
  public long mDuration;
  @SuppressLint({"HandlerLeak"})
  private ap mHandler;
  
  private b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(142861);
    this.mDuration = 3000L;
    this.mHandler = new ap()
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
  
  public static b ky(Context paramContext)
  {
    AppMethodBeat.i(142862);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495765, null);
    ((TextView)paramContext.findViewById(2131305957)).setVisibility(8);
    b localb = new b(paramContext);
    localb.setFocusable(false);
    localb.setContentView(paramContext);
    localb.setWidth(-1);
    localb.setHeight(-1);
    localb.setAnimationStyle(2131821482);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.b
 * JD-Core Version:    0.7.0.1
 */