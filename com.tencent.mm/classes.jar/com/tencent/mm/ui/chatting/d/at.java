package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

@com.tencent.mm.ui.chatting.d.a.a(gRF=aj.class)
public class at
  extends a
  implements aj
{
  private IListener<tr> Ptf;
  long lastClickTime;
  
  public at()
  {
    AppMethodBeat.i(233180);
    this.Ptf = new IListener() {};
    AppMethodBeat.o(233180);
  }
  
  public final void cFy() {}
  
  public final void gIk() {}
  
  public final void gIm()
  {
    AppMethodBeat.i(233181);
    EventCenter.instance.add(this.Ptf);
    AppMethodBeat.o(233181);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(233182);
    EventCenter.instance.removeListener(this.Ptf);
    this.dom.Pwg = false;
    AppMethodBeat.o(233182);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(233183);
    super.gOK();
    EventCenter.instance.removeListener(this.Ptf);
    this.dom.Pwg = false;
    AppMethodBeat.o(233183);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(233184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(233184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.at
 * JD-Core Version:    0.7.0.1
 */