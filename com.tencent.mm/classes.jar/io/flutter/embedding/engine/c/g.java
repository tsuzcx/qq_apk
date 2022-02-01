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
  public d MEJ;
  private final k.c MEK;
  public final k vCn;
  
  public g(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.MEK = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (g.this.MEJ == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        a.gea();
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
            paramAnonymousd.djR();
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
        paramAnonymousj = (Map)paramAnonymousj.grf;
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
            paramAnonymousd.de(Long.valueOf(g.this.MEJ.a(paramAnonymousj)));
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
        i = ((Integer)paramAnonymousj.grf).intValue();
        try
        {
          g.this.MEJ.aja(i);
          paramAnonymousd.de(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.grf;
        paramAnonymousj = new g.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          g.this.MEJ.a(paramAnonymousj, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousd.de(null);
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
        paramAnonymousj = (List)paramAnonymousj.grf;
        paramAnonymousj = new g.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue());
        try
        {
          g.this.MEJ.a(paramAnonymousj);
          paramAnonymousd.de(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.grf;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          g.this.MEJ.lj(i, j);
          paramAnonymousd.de(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.f("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.grf).intValue();
        try
        {
          g.this.MEJ.ajb(i);
          paramAnonymousd.de(null);
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
    this.vCn = new k(paramDartExecutor, "flutter/platform_views", o.MGa);
    this.vCn.a(this.MEK);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String MEN;
    public final double MEO;
    public final double MEP;
    public final ByteBuffer MEQ;
    public final int direction;
    public final int viewId;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.MEN = paramString;
      this.MEO = paramDouble1;
      this.MEP = paramDouble2;
      this.direction = paramInt2;
      this.MEQ = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double MER;
    public final double MES;
    public final int viewId;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.MER = paramDouble1;
      this.MES = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final int MDV;
    public final Number MET;
    public final Number MEU;
    public final Object MEV;
    public final Object MEW;
    public final int MEX;
    public final float MEY;
    public final float MEZ;
    public final int MEa;
    public final int action;
    public final int dnh;
    public final int edgeFlags;
    public final int flags;
    public final int jvu;
    public final int viewId;
    
    c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.viewId = paramInt1;
      this.MET = paramNumber1;
      this.MEU = paramNumber2;
      this.action = paramInt2;
      this.jvu = paramInt3;
      this.MEV = paramObject1;
      this.MEW = paramObject2;
      this.MEa = paramInt4;
      this.MEX = paramInt5;
      this.MEY = paramFloat1;
      this.MEZ = paramFloat2;
      this.MDV = paramInt6;
      this.edgeFlags = paramInt7;
      this.dnh = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface d
  {
    public abstract long a(g.a parama);
    
    public abstract void a(g.b paramb, Runnable paramRunnable);
    
    public abstract void a(g.c paramc);
    
    public abstract void aja(int paramInt);
    
    public abstract void ajb(int paramInt);
    
    public abstract void lj(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g
 * JD-Core Version:    0.7.0.1
 */