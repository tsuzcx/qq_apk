package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class mk<T, S extends mq>
{
  private static final oe<mq, Boolean> d;
  private final mg<T, S> a;
  private final mc b;
  private int c;
  
  static
  {
    AppMethodBeat.i(100513);
    d = new mk.2();
    AppMethodBeat.o(100513);
  }
  
  private mk(mc parammc)
  {
    this(null, 0, parammc);
  }
  
  private mk(mg<T, S> parammg, int paramInt, mc parammc)
  {
    this.a = parammg;
    this.c = paramInt;
    this.b = parammc;
  }
  
  public static a a(int paramInt)
  {
    AppMethodBeat.i(149317);
    a locala = new a(null).a(paramInt);
    AppMethodBeat.o(149317);
    return locala;
  }
  
  public static oe<mq, Boolean> a(mv parammv)
  {
    AppMethodBeat.i(149321);
    parammv = new mk.1(parammv);
    AppMethodBeat.o(149321);
    return parammv;
  }
  
  public final mk<T, S> a(md<? extends T, ? extends S> parammd)
  {
    AppMethodBeat.i(149318);
    if (this.a != null)
    {
      parammd = this.a.a(parammd);
      if (parammd.size() == 1) {}
      for (parammd = (mg)parammd.get(0);; parammd = new mi(parammd, this.b))
      {
        parammd = new mk(parammd, this.c + 1, this.b);
        AppMethodBeat.o(149318);
        return parammd;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, new md[] { parammd });
    parammd = new mk(new mf(localArrayList, this.b), this.c + 1, this.b);
    AppMethodBeat.o(149318);
    return parammd;
  }
  
  public final mk<T, S> a(T paramT, S paramS)
  {
    AppMethodBeat.i(149319);
    paramT = a(md.a(paramT, paramS));
    AppMethodBeat.o(149319);
    return paramT;
  }
  
  final nu<md<T, S>> a(oe<? super mq, Boolean> paramoe)
  {
    AppMethodBeat.i(149320);
    if (this.a != null)
    {
      paramoe = nu.a(new mj(this.a, paramoe));
      AppMethodBeat.o(149320);
      return paramoe;
    }
    paramoe = nu.a();
    AppMethodBeat.o(149320);
    return paramoe;
  }
  
  public final nu<md<T, S>> b(mv parammv)
  {
    AppMethodBeat.i(149322);
    parammv = a(a(parammv));
    AppMethodBeat.o(149322);
    return parammv;
  }
  
  public static class a
  {
    private Integer a;
    private Integer b;
    private mn c;
    private ml d;
    private boolean e;
    
    private a()
    {
      AppMethodBeat.i(149313);
      this.a = null;
      this.b = null;
      this.c = new mo();
      this.d = new mm();
      this.e = false;
      AppMethodBeat.o(149313);
    }
    
    public a a(int paramInt)
    {
      AppMethodBeat.i(149314);
      this.b = Integer.valueOf(paramInt);
      AppMethodBeat.o(149314);
      return this;
    }
    
    public <T, S extends mq> mk<T, S> a()
    {
      AppMethodBeat.i(149316);
      if (this.a == null) {
        this.a = Integer.valueOf(4);
      }
      if (this.b == null) {
        this.b = Integer.valueOf((int)Math.round(this.a.intValue() * 0.4D));
      }
      mk localmk = new mk(new mc(this.b.intValue(), this.a.intValue(), this.d, this.c), null);
      AppMethodBeat.o(149316);
      return localmk;
    }
    
    public a b(int paramInt)
    {
      AppMethodBeat.i(149315);
      this.a = Integer.valueOf(paramInt);
      AppMethodBeat.o(149315);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mk
 * JD-Core Version:    0.7.0.1
 */