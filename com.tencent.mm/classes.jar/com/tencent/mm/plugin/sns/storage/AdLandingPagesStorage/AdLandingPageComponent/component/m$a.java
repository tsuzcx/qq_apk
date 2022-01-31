package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.Serializable;

final class m$a
  extends com.tencent.mm.sdk.d.d
  implements Serializable
{
  c rvL;
  c rvM;
  c rvN;
  c rvO;
  c rvP;
  c rvQ;
  c rvR;
  c rvS;
  c rvT;
  
  protected m$a(m paramm, String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    AppMethodBeat.i(37141);
    this.rvL = new m.a.c(this);
    this.rvM = new m.a.g(this);
    this.rvN = new m.a.e(this);
    this.rvO = new m.a.h(this);
    this.rvP = new m.a.i(this);
    this.rvQ = new m.a.f(this);
    this.rvR = new m.a.b(this);
    this.rvS = new m.a.a(this);
    this.rvT = new m.a.d(this);
    a(this.rvM);
    a(this.rvL);
    a(this.rvN);
    a(this.rvO);
    a(this.rvP);
    a(this.rvQ);
    a(this.rvR);
    a(this.rvS);
    a(this.rvT);
    b(this.rvT);
    AppMethodBeat.o(37141);
  }
  
  final class c$a
    implements AdLandingPagesProxy.a
  {
    private c$a() {}
    
    public final void DE(int paramInt)
    {
      AppMethodBeat.i(37115);
      m.a locala = m.a(m.a.this.rvU.rvI);
      d.c localc = locala.yrd;
      if (localc != null) {
        localc.sendMessage(Message.obtain(locala.yrd, 1, paramInt, 0));
      }
      AppMethodBeat.o(37115);
    }
    
    public final void cob()
    {
      AppMethodBeat.i(37116);
      ab.i("LogStateTransitionState", "paused");
      m.a(m.a.this.rvU.rvI).sendMessage(7);
      AppMethodBeat.o(37116);
    }
    
    public final void coc()
    {
      AppMethodBeat.i(37117);
      m.a(m.a.this.rvU.rvI).sendMessage(9);
      AppMethodBeat.o(37117);
    }
    
    public final void cod()
    {
      AppMethodBeat.i(37118);
      m.a(m.a.this.rvU.rvI).sendMessage(8);
      AppMethodBeat.o(37118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a
 * JD-Core Version:    0.7.0.1
 */