package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import java.util.List;

public final class l
{
  protected static long zcb = 16000L;
  protected static int zcc = 54158;
  public int zcd;
  public b zce;
  
  public final b a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.zcd)
    {
      paramContext = this.zce;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.zce != null) {
      this.zce.dRP();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.zcd = paramInt;
      this.zce.init();
      paramContext = this.zce;
      AppMethodBeat.o(28148);
      return paramContext;
      this.zce = new c(paramContext, parama);
      continue;
      this.zce = j.a(parama);
      continue;
      this.zce = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.zce = new h(parama);
      continue;
      this.zce = new g(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, e parame, long paramLong);
    
    public abstract void d(List<d> paramList, long paramLong);
  }
  
  public static abstract class b
  {
    public l.a zcf;
    protected boolean zcg = false;
    protected long zch = l.zcb;
    private aq zci = new aq(new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.zcc) && (!l.b.this.zcg) && (l.b.this.zcf != null)) {
          l.b.this.zcf.d(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.zcf = parama;
    }
    
    public void dRP()
    {
      reset();
      this.zcf = null;
    }
    
    public abstract void init();
    
    public abstract void pause();
    
    public abstract void reset();
    
    public abstract void resume();
    
    public abstract void start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l
 * JD-Core Version:    0.7.0.1
 */