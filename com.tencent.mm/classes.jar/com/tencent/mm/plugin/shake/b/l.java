package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.List;

public final class l
{
  protected static long yLR = 16000L;
  protected static int yLS = 54158;
  public int yLT;
  public b yLU;
  
  public final b a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.yLT)
    {
      paramContext = this.yLU;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.yLU != null) {
      this.yLU.dOs();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.yLT = paramInt;
      this.yLU.init();
      paramContext = this.yLU;
      AppMethodBeat.o(28148);
      return paramContext;
      this.yLU = new c(paramContext, parama);
      continue;
      this.yLU = j.a(parama);
      continue;
      this.yLU = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.yLU = new h(parama);
      continue;
      this.yLU = new g(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, e parame, long paramLong);
    
    public abstract void d(List<d> paramList, long paramLong);
  }
  
  public static abstract class b
  {
    public l.a yLV;
    protected boolean yLW = false;
    protected long yLX = l.yLR;
    private ap yLY = new ap(new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.yLS) && (!l.b.this.yLW) && (l.b.this.yLV != null)) {
          l.b.this.yLV.d(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.yLV = parama;
    }
    
    public void dOs()
    {
      reset();
      this.yLV = null;
    }
    
    public abstract void init();
    
    public abstract void pause();
    
    public abstract void reset();
    
    public abstract void resume();
    
    public abstract void start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l
 * JD-Core Version:    0.7.0.1
 */