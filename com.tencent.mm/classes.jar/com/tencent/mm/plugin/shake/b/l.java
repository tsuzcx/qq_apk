package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.List;

public final class l
{
  protected static long DgT = 16000L;
  protected static int DgU = 54158;
  public int DgV;
  public b DgW;
  
  public final b a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.DgV)
    {
      paramContext = this.DgW;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.DgW != null) {
      this.DgW.eTQ();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.DgV = paramInt;
      this.DgW.init();
      paramContext = this.DgW;
      AppMethodBeat.o(28148);
      return paramContext;
      this.DgW = new c(paramContext, parama);
      continue;
      this.DgW = j.a(parama);
      continue;
      this.DgW = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.DgW = new h(parama);
      continue;
      this.DgW = new g(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, e parame, long paramLong);
    
    public abstract void f(List<d> paramList, long paramLong);
  }
  
  public static abstract class b
  {
    public l.a DgX;
    protected boolean DgY = false;
    protected long DgZ = l.DgT;
    private MMHandler Dha = new MMHandler(new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.DgU) && (!l.b.this.DgY) && (l.b.this.DgX != null)) {
          l.b.this.DgX.f(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.DgX = parama;
    }
    
    public void eTQ()
    {
      reset();
      this.DgX = null;
    }
    
    public abstract void init();
    
    public abstract void pause();
    
    public abstract void reset();
    
    public abstract void resume();
    
    public abstract void start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l
 * JD-Core Version:    0.7.0.1
 */