package com.tencent.threadpool;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.b.d;
import com.tencent.threadpool.g.a.b;
import com.tencent.threadpool.g.h.a;

public final class a
{
  public static g.b ahzV;
  public static boolean eYL;
  public long KSt;
  public int ahzN;
  public int ahzO;
  public int ahzP;
  public b ahzQ;
  public h.a ahzR;
  public d ahzS;
  public boolean ahzT = true;
  public boolean ahzU = false;
  
  static
  {
    AppMethodBeat.i(226928);
    eYL = false;
    ahzV = new g.b()
    {
      public final void a(Thread paramAnonymousThread, String paramAnonymousString) {}
      
      public final boolean gzk()
      {
        return false;
      }
      
      public final boolean gzl()
      {
        return false;
      }
      
      public final boolean gzm()
      {
        return false;
      }
    };
    AppMethodBeat.o(226928);
  }
  
  public static final class a
  {
    public a ahzW;
    
    public a()
    {
      AppMethodBeat.i(183098);
      this.ahzW = new a((byte)0);
      AppMethodBeat.o(183098);
    }
    
    public final a a(h.a parama)
    {
      this.ahzW.ahzR = parama;
      return this;
    }
    
    public final a aHn(int paramInt)
    {
      this.ahzW.ahzP = paramInt;
      return this;
    }
    
    public final a jYL()
    {
      this.ahzW.KSt = 259200000L;
      return this;
    }
    
    public final a jYM()
    {
      this.ahzW.ahzT = true;
      return this;
    }
    
    public final a pJ(int paramInt1, int paramInt2)
    {
      this.ahzW.ahzO = paramInt1;
      this.ahzW.ahzN = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.a
 * JD-Core Version:    0.7.0.1
 */