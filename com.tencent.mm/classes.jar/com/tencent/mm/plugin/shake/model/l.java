package com.tencent.mm.plugin.shake.model;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.plugin.shake.c.a.j;
import com.tencent.mm.plugin.shake.c.a.m;
import com.tencent.mm.plugin.shake.c.a.o;
import com.tencent.mm.plugin.shake.shakecard.a.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.List;

public final class l
{
  protected static long Pzp = 16000L;
  protected static int Pzq = 54158;
  public int Pzr;
  public b Pzs;
  public long startTime;
  
  public l()
  {
    AppMethodBeat.i(273525);
    a locala = a.PyM;
    a.gWE();
    AppMethodBeat.o(273525);
  }
  
  public final b a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(28148);
    if ((paramInt == this.Pzr) && (this.Pzs.Pzt != null))
    {
      paramContext = this.Pzs;
      AppMethodBeat.o(28148);
      return paramContext;
    }
    if ((this.Pzs != null) && (this.Pzs.Pzt != null)) {
      this.Pzs.gWH();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.Pzr = paramInt;
      paramContext = a.PyM;
      a.setTabType(this.Pzr);
      this.Pzs.init();
      paramContext = this.Pzs;
      AppMethodBeat.o(28148);
      return paramContext;
      this.Pzs = new c(parama);
      continue;
      this.Pzs = m.a(parama);
      continue;
      this.Pzs = new o(paramContext, parama);
      continue;
      this.Pzs = new j(parama);
      continue;
      this.Pzs = new f(parama);
    }
  }
  
  public final long gXb()
  {
    AppMethodBeat.i(273537);
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    AppMethodBeat.o(273537);
    return l1 - l2;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.shake.shakecard.a.d paramd, long paramLong);
    
    public abstract void g(List<d> paramList, long paramLong);
  }
  
  public static abstract class b
  {
    public l.a Pzt;
    protected boolean Pzu = false;
    protected long Pzv = l.Pzp;
    private MMHandler Pzw = new MMHandler(new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(28147);
        if ((paramAnonymousMessage.what == l.Pzq) && (!l.b.this.Pzu) && (l.b.this.Pzt != null)) {
          l.b.this.Pzt.g(null, 5L);
        }
        AppMethodBeat.o(28147);
        return false;
      }
    });
    
    public b(l.a parama)
    {
      this.Pzt = parama;
    }
    
    public void gWH()
    {
      reset();
      this.Pzt = null;
    }
    
    public abstract void init();
    
    public abstract void pause();
    
    public abstract void reset();
    
    public abstract void resume();
    
    public abstract void start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.l
 * JD-Core Version:    0.7.0.1
 */