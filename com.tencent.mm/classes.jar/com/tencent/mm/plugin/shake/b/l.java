package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class l
{
  protected static long wlQ = 16000L;
  protected static int wlR = 54158;
  public int wlS;
  public b wlT;
  
  public final b a(Context paramContext, int paramInt, l.a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.wlS)
    {
      paramContext = this.wlT;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.wlT != null) {
      this.wlT.doF();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.wlS = paramInt;
      this.wlT.init();
      paramContext = this.wlT;
      AppMethodBeat.o(28148);
      return paramContext;
      this.wlT = new c(paramContext, parama);
      continue;
      this.wlT = j.a(parama);
      continue;
      this.wlT = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.wlT = new h(parama);
      continue;
      this.wlT = new g(parama);
    }
  }
  
  public static abstract class b
  {
    public l.a wlU;
    protected boolean wlV = false;
    protected long wlW = l.wlQ;
    private ap wlX = new ap(new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.wlR) && (!l.b.this.wlV) && (l.b.this.wlU != null)) {
          l.b.this.wlU.c(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.wlU = parama;
    }
    
    public void doF()
    {
      reset();
      this.wlU = null;
    }
    
    public abstract void init();
    
    public abstract void pause();
    
    public abstract void reset();
    
    public abstract void resume();
    
    public abstract void start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l
 * JD-Core Version:    0.7.0.1
 */