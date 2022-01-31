package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;

public abstract class l$b
{
  public l.a qNe;
  protected boolean qNf = false;
  protected long qNg = l.qNa;
  private ak qNh = new ak(new ak.a()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(24472);
      if ((paramAnonymousMessage.what == l.qNb) && (!l.b.this.qNf) && (l.b.this.qNe != null)) {
        l.b.this.qNe.b(null, 5L);
      }
      AppMethodBeat.o(24472);
      return false;
    }
  });
  
  public l$b(l.a parama)
  {
    this.qNe = parama;
  }
  
  public void ckR()
  {
    reset();
    this.qNe = null;
  }
  
  public abstract void init();
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void resume();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l.b
 * JD-Core Version:    0.7.0.1
 */