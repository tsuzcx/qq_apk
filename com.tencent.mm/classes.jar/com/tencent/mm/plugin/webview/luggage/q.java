package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import com.tencent.luggage.e.d;
import com.tencent.luggage.e.f;
import com.tencent.luggage.e.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

public class q
  extends f
{
  public q(Activity paramActivity)
  {
    super(paramActivity);
    this.bip = h.class;
    this.bis.x(ay.aGk());
  }
  
  private void cbr()
  {
    SwipeBackLayout localSwipeBackLayout;
    if ((this.mContext instanceof MMActivity))
    {
      localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.bix.getPageStack().size() > 1) {
          break label45;
        }
        localSwipeBackLayout.setEnableGesture(true);
      }
    }
    return;
    label45:
    localSwipeBackLayout.setEnableGesture(false);
  }
  
  public final void onResume()
  {
    super.onResume();
    cbr();
  }
  
  protected final void qh()
  {
    ((e)qd()).caQ();
    cbr();
  }
  
  protected final void qi()
  {
    cbr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */