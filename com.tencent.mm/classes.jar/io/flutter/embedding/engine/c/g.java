package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.o;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class g
{
  public d NbP;
  private final k.c NbQ;
  public final k vOr;
  
  public g(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.NbQ = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (g.this.NbP == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        a.giD();
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
            paramAnonymousd.dmQ();
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
        paramAnonymousj = (Map)paramAnonymousj.gtF;
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
            paramAnonymousd.df(Long.valueOf(g.this.NbP.a(paramAnonymousj)));
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            paramAnonymousd.f("error", g.q(paramAnonymousj), null);
            AppMethodBeat.o(10241);
            return;
          }
        }
        i = ((Integer)paramAnonymousj.gtF).intValue();
        try
        {
          g.this.NbP.ajK(i);
          paramAnonymousd.df(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.gtF;
        paramAnonymousj = new g.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          g.this.NbP.a(paramAnonymousj, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousd.df(null);
              AppMethodBeat.o(10253);
            }
          });
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (List)paramAnonymousj.gtF;
        paramAnonymousj = new g.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue());
        try
        {
          g.this.NbP.a(paramAnonymousj);
          paramAnonymousd.df(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.gtF;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          g.this.NbP.lq(i, j);
          paramAnonymousd.df(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.gtF).intValue();
        try
        {
          g.this.NbP.ajL(i);
          paramAnonymousd.df(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
        }
      }
    };
    this.vOr = new k(paramDartExecutor, "flutter/platform_views", o.Ndg);
    this.vOr.a(this.NbQ);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String NbT;
    public final double NbU;
    public final double NbV;
    public final ByteBuffer NbW;
    public final int direction;
    public final int viewId;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.NbT = paramString;
      this.NbU = paramDouble1;
      this.NbV = paramDouble2;
      this.direction = paramInt2;
      this.NbW = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double NbX;
    public final double NbY;
    public final int viewId;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.NbX = paramDouble1;
      this.NbY = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final Number NbZ;
    public final int Nbb;
    public final int Nbg;
    public final Number Nca;
    public final Object Ncb;
    public final Object Ncc;
    public final int Ncd;
    public final float Nce;
    public final float Ncf;
    public final int action;
    public final int doj;
    public final int edgeFlags;
    public final int flags;
    public final int jyp;
    public final int viewId;
    
    c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.viewId = paramInt1;
      this.NbZ = paramNumber1;
      this.Nca = paramNumber2;
      this.action = paramInt2;
      this.jyp = paramInt3;
      this.Ncb = paramObject1;
      this.Ncc = paramObject2;
      this.Nbg = paramInt4;
      this.Ncd = paramInt5;
      this.Nce = paramFloat1;
      this.Ncf = paramFloat2;
      this.Nbb = paramInt6;
      this.edgeFlags = paramInt7;
      this.doj = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface d
  {
    public abstract long a(g.a parama);
    
    public abstract void a(g.b paramb, Runnable paramRunnable);
    
    public abstract void a(g.c paramc);
    
    public abstract void ajK(int paramInt);
    
    public abstract void ajL(int paramInt);
    
    public abstract void lq(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g
 * JD-Core Version:    0.7.0.1
 */