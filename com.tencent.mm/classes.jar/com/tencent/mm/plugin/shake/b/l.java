package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;

public final class l
{
  protected static long xxg = 16000L;
  protected static int xxh = 54158;
  public int xxi;
  public b xxj;
  
  public final b a(Context paramContext, int paramInt, l.a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.xxi)
    {
      paramContext = this.xxj;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.xxj != null) {
      this.xxj.dCP();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.xxi = paramInt;
      this.xxj.init();
      paramContext = this.xxj;
      AppMethodBeat.o(28148);
      return paramContext;
      this.xxj = new c(paramContext, parama);
      continue;
      this.xxj = j.a(parama);
      continue;
      this.xxj = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.xxj = new h(parama);
      continue;
      this.xxj = new g(parama);
    }
  }
  
  public static abstract class b
  {
    public l.a xxk;
    protected boolean xxl = false;
    protected long xxm = l.xxg;
    private ao xxn = new ao(new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.xxh) && (!l.b.this.xxl) && (l.b.this.xxk != null)) {
          l.b.this.xxk.d(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.xxk = parama;
    }
    
    public void dCP()
    {
      reset();
      this.xxk = null;
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