package com.tencent.mm.plugin.remittance.mobile.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class MobileRemitHistoryRecodUI$4
  implements RecyclerView.l
{
  MobileRemitHistoryRecodUI$4(MobileRemitHistoryRecodUI paramMobileRemitHistoryRecodUI) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189969);
    MobileRemitHistoryRecodUI.d(this.ylE)[0] = ((int)paramMotionEvent.getRawX());
    MobileRemitHistoryRecodUI.d(this.ylE)[1] = ((int)paramMotionEvent.getRawY());
    ae.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(MobileRemitHistoryRecodUI.d(this.ylE)[0]), Integer.valueOf(MobileRemitHistoryRecodUI.d(this.ylE)[1]) });
    AppMethodBeat.o(189969);
    return false;
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189970);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(189970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.4
 * JD-Core Version:    0.7.0.1
 */