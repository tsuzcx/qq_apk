package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.k;
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
    AppMethodBeat.i(288904);
    MobileRemitHistoryRecodUI.d(this.Ogj)[0] = ((int)paramMotionEvent.getRawX());
    MobileRemitHistoryRecodUI.d(this.Ogj)[1] = ((int)paramMotionEvent.getRawY());
    Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(MobileRemitHistoryRecodUI.d(this.Ogj)[0]), Integer.valueOf(MobileRemitHistoryRecodUI.d(this.Ogj)[1]) });
    AppMethodBeat.o(288904);
    return false;
  }
  
  public final void aX(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(288905);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$4", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(288905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.4
 * JD-Core Version:    0.7.0.1
 */