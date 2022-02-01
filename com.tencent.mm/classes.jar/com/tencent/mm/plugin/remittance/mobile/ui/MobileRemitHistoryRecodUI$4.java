package com.tencent.mm.plugin.remittance.mobile.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class MobileRemitHistoryRecodUI$4
  implements RecyclerView.k
{
  MobileRemitHistoryRecodUI$4(MobileRemitHistoryRecodUI paramMobileRemitHistoryRecodUI) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213713);
    MobileRemitHistoryRecodUI.d(this.CmE)[0] = ((int)paramMotionEvent.getRawX());
    MobileRemitHistoryRecodUI.d(this.CmE)[1] = ((int)paramMotionEvent.getRawY());
    Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(MobileRemitHistoryRecodUI.d(this.CmE)[0]), Integer.valueOf(MobileRemitHistoryRecodUI.d(this.CmE)[1]) });
    AppMethodBeat.o(213713);
    return false;
  }
  
  public final void ah(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(213714);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(213714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.4
 * JD-Core Version:    0.7.0.1
 */