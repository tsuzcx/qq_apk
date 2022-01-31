package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

final class c$c
  implements Runnable
{
  private WeakReference<a> Byo;
  private WeakReference<b> Byp;
  private c.a Byq;
  private int key;
  private Object object;
  
  public c$c(c paramc, a parama, b paramb, c.a parama1, int paramInt)
  {
    AppMethodBeat.i(113236);
    this.Byo = new WeakReference(parama);
    this.Byp = new WeakReference(paramb);
    this.Byq = parama1;
    this.key = paramInt;
    AppMethodBeat.o(113236);
  }
  
  public final void run()
  {
    AppMethodBeat.i(113237);
    Object localObject = (a)this.Byo.get();
    b localb = (b)this.Byp.get();
    if ((localObject != null) && (localb != null))
    {
      this.object = localb.dWQ();
      localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = this;
      c.a(this.Bym).sendMessage((Message)localObject);
    }
    AppMethodBeat.o(113237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.e.c.c
 * JD-Core Version:    0.7.0.1
 */