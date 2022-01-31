package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c$d
  implements Runnable
{
  private WeakReference<b> Byp;
  private WeakReference<f> Byr;
  private c.b Bys;
  private Object object;
  
  public c$d(c paramc, f paramf, b paramb, c.b paramb1)
  {
    AppMethodBeat.i(113238);
    this.Byr = new WeakReference(paramf);
    this.Byp = new WeakReference(paramb);
    this.Bys = paramb1;
    AppMethodBeat.o(113238);
  }
  
  public final void run()
  {
    AppMethodBeat.i(113239);
    Object localObject = (b)this.Byp.get();
    f localf = (f)this.Byr.get();
    if ((localObject != null) && (localf != null))
    {
      this.object = ((b)localObject).dWQ();
      localObject = new Message();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = this;
      c.a(this.Bym).sendMessage((Message)localObject);
    }
    AppMethodBeat.o(113239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.toybrick.e.c.d
 * JD-Core Version:    0.7.0.1
 */