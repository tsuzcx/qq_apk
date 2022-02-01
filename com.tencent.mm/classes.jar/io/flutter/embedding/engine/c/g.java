package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.a.a.j;
import io.flutter.a.a.k;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.o;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class g
{
  public d Jaj;
  private final k.c Jak;
  public final k sNT;
  
  public g(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.Jak = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (g.this.Jaj == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        a.ftS();
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.Av();
            AppMethodBeat.o(10241);
            return;
            if (str.equals("create"))
            {
              i = 0;
              continue;
              if (str.equals("dispose"))
              {
                i = 1;
                continue;
                if (str.equals("resize"))
                {
                  i = 2;
                  continue;
                  if (str.equals("touch"))
                  {
                    i = 3;
                    continue;
                    if (str.equals("setDirection"))
                    {
                      i = 4;
                      continue;
                      if (str.equals("clearFocus")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        paramAnonymousj = (Map)paramAnonymousj.fTP;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        str = (String)paramAnonymousj.get("viewType");
        double d1 = ((Double)paramAnonymousj.get("width")).doubleValue();
        double d2 = ((Double)paramAnonymousj.get("height")).doubleValue();
        int j = ((Integer)paramAnonymousj.get("direction")).intValue();
        if (paramAnonymousj.containsKey("params")) {}
        for (paramAnonymousj = ByteBuffer.wrap((byte[])paramAnonymousj.get("params"));; paramAnonymousj = null)
        {
          paramAnonymousj = new g.a(i, str, d1, d2, j, paramAnonymousj);
          try
          {
            paramAnonymousd.ay(Long.valueOf(g.this.Jaj.a(paramAnonymousj)));
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
            AppMethodBeat.o(10241);
            return;
          }
        }
        i = ((Integer)paramAnonymousj.fTP).intValue();
        try
        {
          g.this.Jaj.adE(i);
          paramAnonymousd.ay(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.fTP;
        paramAnonymousj = new g.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          g.this.Jaj.a(paramAnonymousj, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousd.ay(null);
              AppMethodBeat.o(10253);
            }
          });
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (List)paramAnonymousj.fTP;
        paramAnonymousj = new g.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue());
        try
        {
          g.this.Jaj.a(paramAnonymousj);
          paramAnonymousd.ay(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.fTP;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          g.this.Jaj.kE(i, j);
          paramAnonymousd.ay(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.fTP).intValue();
        try
        {
          g.this.Jaj.adF(i);
          paramAnonymousd.ay(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10241);
        }
      }
    };
    this.sNT = new k(paramDartExecutor, "flutter/platform_views", o.Jbz);
    this.sNT.a(this.Jak);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String Jan;
    public final double Jao;
    public final double Jap;
    public final ByteBuffer Jaq;
    public final int direction;
    public final int dpo;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.dpo = paramInt1;
      this.Jan = paramString;
      this.Jao = paramDouble1;
      this.Jap = paramDouble2;
      this.direction = paramInt2;
      this.Jaq = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double Jar;
    public final double Jas;
    public final int dpo;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.dpo = paramInt;
      this.Jar = paramDouble1;
      this.Jas = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final int IZA;
    public final int IZv;
    public final Number Jat;
    public final Number Jau;
    public final Object Jav;
    public final Object Jaw;
    public final int Jax;
    public final float Jay;
    public final float Jaz;
    public final int action;
    public final int dep;
    public final int dpo;
    public final int edgeFlags;
    public final int flags;
    public final int iCk;
    
    c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.dpo = paramInt1;
      this.Jat = paramNumber1;
      this.Jau = paramNumber2;
      this.action = paramInt2;
      this.iCk = paramInt3;
      this.Jav = paramObject1;
      this.Jaw = paramObject2;
      this.IZA = paramInt4;
      this.Jax = paramInt5;
      this.Jay = paramFloat1;
      this.Jaz = paramFloat2;
      this.IZv = paramInt6;
      this.edgeFlags = paramInt7;
      this.dep = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface d
  {
    public abstract long a(g.a parama);
    
    public abstract void a(g.b paramb, Runnable paramRunnable);
    
    public abstract void a(g.c paramc);
    
    public abstract void adE(int paramInt);
    
    public abstract void adF(int paramInt);
    
    public abstract void kE(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g
 * JD-Core Version:    0.7.0.1
 */