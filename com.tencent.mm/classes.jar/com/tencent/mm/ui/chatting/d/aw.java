package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.uu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ak.class)
public class aw
  extends a
  implements ak
{
  private IListener<uu> WNJ;
  long lastClickTime;
  
  public aw()
  {
    AppMethodBeat.i(271220);
    this.WNJ = new IListener() {};
    AppMethodBeat.o(271220);
  }
  
  public final void hGU() {}
  
  public final void hGW()
  {
    AppMethodBeat.i(271221);
    EventCenter.instance.add(this.WNJ);
    AppMethodBeat.o(271221);
  }
  
  public final void hGY() {}
  
  public final void hGZ()
  {
    AppMethodBeat.i(271222);
    EventCenter.instance.removeListener(this.WNJ);
    this.fgR.WQz = false;
    AppMethodBeat.o(271222);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(271223);
    super.hNZ();
    EventCenter.instance.removeListener(this.WNJ);
    this.fgR.WQz = false;
    AppMethodBeat.o(271223);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271224);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(271224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aw
 * JD-Core Version:    0.7.0.1
 */