package com.tencent.mm.ui.chatting.component;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.wk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.chatting.component.api.ar;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ar.class)
public class bd
  extends a
  implements ar
{
  private IListener<wk> aewj;
  long lastClickTime;
  
  public bd()
  {
    AppMethodBeat.i(256355);
    this.aewj = new RemittanceSearchComponent.1(this, f.hfK);
    AppMethodBeat.o(256355);
  }
  
  public final void jjf() {}
  
  public final void jjh()
  {
    AppMethodBeat.i(256365);
    this.aewj.alive();
    AppMethodBeat.o(256365);
  }
  
  public final void jjj() {}
  
  public final void jjk()
  {
    AppMethodBeat.i(256368);
    this.aewj.dead();
    this.hlc.aezS = false;
    AppMethodBeat.o(256368);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(256372);
    super.jqF();
    this.aewj.dead();
    this.hlc.aezS = false;
    AppMethodBeat.o(256372);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256376);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(256376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bd
 * JD-Core Version:    0.7.0.1
 */