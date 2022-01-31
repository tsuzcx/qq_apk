package com.tencent.mm.ui.chatting;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;

public final class r
{
  public static r.b vka = new r.b();
  
  public static void dG(View paramView)
  {
    Object localObject = vka;
    if ((paramView == null) || (localObject == null)) {
      y.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
    }
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 14);
      ak localak = ak.cDg();
      if ((Build.VERSION.SDK_INT >= 14) && (localak.vmA == null)) {
        localak.vmA = new ak.a((ak.b)localObject);
      }
      localObject = localak.vmA;
    } while ((localObject == null) || (Build.VERSION.SDK_INT < 14) || (!(localObject instanceof View.OnHoverListener)));
    paramView.setOnHoverListener((View.OnHoverListener)localObject);
  }
  
  public static void dismiss()
  {
    try
    {
      if (vka != null) {
        r.b.a(vka);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */