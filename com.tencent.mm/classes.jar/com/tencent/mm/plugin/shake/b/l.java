package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.List;

public final class l
{
  protected static int JmA = 54158;
  protected static long Jmz = 16000L;
  public int JmB;
  public b JmC;
  
  public final b a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(28148);
    if (paramInt == this.JmB)
    {
      paramContext = this.JmC;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if (this.JmC != null) {
      this.JmC.fGS();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.JmB = paramInt;
      this.JmC.init();
      paramContext = this.JmC;
      AppMethodBeat.o(28148);
      return paramContext;
      this.JmC = new c(paramContext, parama);
      continue;
      this.JmC = j.a(parama);
      continue;
      this.JmC = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.JmC = new h(parama);
      continue;
      this.JmC = new f(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.shake.c.a.d paramd, long paramLong);
    
    public abstract void e(List<d> paramList, long paramLong);
  }
  
  public static abstract class b
  {
    public l.a JmD;
    protected boolean JmE = false;
    protected long JmF = l.Jmz;
    private MMHandler JmG = new MMHandler(new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.JmA) && (!l.b.this.JmE) && (l.b.this.JmD != null)) {
          l.b.this.JmD.e(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.JmD = parama;
    }
    
    public void fGS()
    {
      reset();
      this.JmD = null;
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