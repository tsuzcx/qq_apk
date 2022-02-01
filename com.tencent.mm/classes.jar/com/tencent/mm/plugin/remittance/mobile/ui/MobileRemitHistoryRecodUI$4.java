package com.tencent.mm.plugin.remittance.mobile.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class MobileRemitHistoryRecodUI$4
  implements RecyclerView.l
{
  MobileRemitHistoryRecodUI$4(MobileRemitHistoryRecodUI paramMobileRemitHistoryRecodUI) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201269);
    MobileRemitHistoryRecodUI.d(this.vxZ)[0] = ((int)paramMotionEvent.getRawX());
    MobileRemitHistoryRecodUI.d(this.vxZ)[1] = ((int)paramMotionEvent.getRawY());
    ad.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(MobileRemitHistoryRecodUI.d(this.vxZ)[0]), Integer.valueOf(MobileRemitHistoryRecodUI.d(this.vxZ)[1]) });
    AppMethodBeat.o(201269);
    return false;
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.4
 * JD-Core Version:    0.7.0.1
 */