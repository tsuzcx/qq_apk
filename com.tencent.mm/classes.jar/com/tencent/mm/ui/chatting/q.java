package com.tencent.mm.ui.chatting;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
{
  public static q.b zzC;
  
  static
  {
    AppMethodBeat.i(30707);
    zzC = new q.b();
    AppMethodBeat.o(30707);
  }
  
  public static void dismiss()
  {
    AppMethodBeat.i(30705);
    try
    {
      if (zzC != null) {
        q.b.a(zzC);
      }
      AppMethodBeat.o(30705);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(30705);
    }
  }
  
  public static void eP(View paramView)
  {
    AppMethodBeat.i(30704);
    Object localObject = zzC;
    if ((paramView == null) || (localObject == null))
    {
      ab.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      AppMethodBeat.o(30704);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ag localag = ag.dGT();
      if ((Build.VERSION.SDK_INT >= 14) && (localag.zBU == null)) {
        localag.zBU = new ag.a((ag.b)localObject);
      }
      localObject = localag.zBU;
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 14) && ((localObject instanceof View.OnHoverListener))) {
        paramView.setOnHoverListener((View.OnHoverListener)localObject);
      }
    }
    AppMethodBeat.o(30704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */