package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.g.b;
import java.lang.ref.WeakReference;

public final class c
{
  public static volatile c Byl;
  private Handler mMainHandler;
  
  static
  {
    AppMethodBeat.i(113244);
    Byl = new c();
    AppMethodBeat.o(113244);
  }
  
  private c()
  {
    AppMethodBeat.i(113240);
    this.mMainHandler = new c.1(this, Looper.getMainLooper());
    AppMethodBeat.o(113240);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(156753);
    a.dWP().execute(paramRunnable);
    AppMethodBeat.o(156753);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, ImageView paramImageView)
  {
    AppMethodBeat.i(113242);
    parama = new c.c(this, parama, paramb, new c.2(this, new WeakReference(paramImageView)), parama.Byt.hashCode());
    a.dWP().execute(parama);
    AppMethodBeat.o(113242);
  }
  
  public final void a(com.tencent.toybrick.f.a parama, b paramb, c.a parama1)
  {
    AppMethodBeat.i(113241);
    parama = new c.c(this, parama, paramb, parama1, parama.Byt.hashCode());
    a.dWP().execute(parama);
    AppMethodBeat.o(113241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.e.c
 * JD-Core Version:    0.7.0.1
 */