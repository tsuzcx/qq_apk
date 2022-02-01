package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.o;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class i
{
  public final k aKT;
  public d aatg;
  private final k.c aath;
  
  public i(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.aath = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (i.this.aatg == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        b.iAd();
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
            paramAnonymousd.epZ();
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
        paramAnonymousj = (Map)paramAnonymousj.ZZe;
        double d1;
        label315:
        double d2;
        label323:
        int k;
        if ((paramAnonymousj.containsKey("hybrid")) && (((Boolean)paramAnonymousj.get("hybrid")).booleanValue()))
        {
          i = 1;
          if (i == 0) {
            break label474;
          }
          d1 = 0.0D;
          if (i == 0) {
            break label492;
          }
          d2 = 0.0D;
          j = ((Integer)paramAnonymousj.get("id")).intValue();
          str = (String)paramAnonymousj.get("viewType");
          k = ((Integer)paramAnonymousj.get("direction")).intValue();
          if (!paramAnonymousj.containsKey("params")) {
            break label511;
          }
        }
        label474:
        label492:
        label511:
        for (paramAnonymousj = ByteBuffer.wrap((byte[])paramAnonymousj.get("params"));; paramAnonymousj = null)
        {
          paramAnonymousj = new i.a(j, str, d1, d2, k, paramAnonymousj);
          if (i == 0) {
            break label516;
          }
          try
          {
            i.this.aatg.a(paramAnonymousj);
            paramAnonymousd.bb(null);
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            paramAnonymousd.b("error", i.o(paramAnonymousj), null);
            AppMethodBeat.o(10241);
            return;
          }
          i = 0;
          break;
          d1 = ((Double)paramAnonymousj.get("width")).doubleValue();
          break label315;
          d2 = ((Double)paramAnonymousj.get("height")).doubleValue();
          break label323;
        }
        label516:
        paramAnonymousd.bb(Long.valueOf(i.this.aatg.b(paramAnonymousj)));
        AppMethodBeat.o(10241);
        return;
        paramAnonymousj = (Map)paramAnonymousj.ZZe;
        int j = ((Integer)paramAnonymousj.get("id")).intValue();
        if ((paramAnonymousj.containsKey("hybrid")) && (((Boolean)paramAnonymousj.get("hybrid")).booleanValue()))
        {
          i = 1;
          if (i == 0) {
            break label639;
          }
        }
        for (;;)
        {
          try
          {
            i.this.aatg.aDo(j);
            paramAnonymousd.bb(null);
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            label639:
            paramAnonymousd.b("error", i.o(paramAnonymousj), null);
            AppMethodBeat.o(10241);
            return;
          }
          i = 0;
          break;
          i.this.aatg.aDp(j);
        }
        paramAnonymousj = (Map)paramAnonymousj.ZZe;
        paramAnonymousj = new i.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          i.this.aatg.a(paramAnonymousj, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousd.bb(null);
              AppMethodBeat.o(10253);
            }
          });
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", i.o(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (List)paramAnonymousj.ZZe;
        paramAnonymousj = new i.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue(), ((Number)paramAnonymousj.get(15)).longValue());
        try
        {
          i.this.aatg.a(paramAnonymousj);
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", i.o(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.ZZe;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          i.this.aatg.om(i, j);
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", i.o(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.ZZe).intValue();
        try
        {
          i.this.aatg.aDq(i);
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", i.o(paramAnonymousj), null);
          AppMethodBeat.o(10241);
        }
      }
    };
    this.aKT = new k(paramDartExecutor, "flutter/platform_views", o.aauS);
    this.aKT.a(this.aath);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String aatl;
    public final double aatm;
    public final double aatn;
    public final ByteBuffer aato;
    public final int direction;
    public final int viewId;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.aatl = paramString;
      this.aatm = paramDouble1;
      this.aatn = paramDouble2;
      this.direction = paramInt2;
      this.aato = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double aatp;
    public final double aatq;
    public final int viewId;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.aatp = paramDouble1;
      this.aatq = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final int aatA;
    public final long aatB;
    public final Number aatr;
    public final Number aats;
    public final Object aatt;
    public final Object aatu;
    public final int aatv;
    public final int aatw;
    public final float aatx;
    public final float aaty;
    public final int aatz;
    public final int action;
    public final int flags;
    public final int nrY;
    public final int source;
    public final int viewId;
    
    public c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong)
    {
      this.viewId = paramInt1;
      this.aatr = paramNumber1;
      this.aats = paramNumber2;
      this.action = paramInt2;
      this.nrY = paramInt3;
      this.aatt = paramObject1;
      this.aatu = paramObject2;
      this.aatv = paramInt4;
      this.aatw = paramInt5;
      this.aatx = paramFloat1;
      this.aaty = paramFloat2;
      this.aatz = paramInt6;
      this.aatA = paramInt7;
      this.source = paramInt8;
      this.flags = paramInt9;
      this.aatB = paramLong;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(i.a parama);
    
    public abstract void a(i.b paramb, Runnable paramRunnable);
    
    public abstract void a(i.c paramc);
    
    public abstract void aDo(int paramInt);
    
    public abstract void aDp(int paramInt);
    
    public abstract void aDq(int paramInt);
    
    public abstract long b(i.a parama);
    
    public abstract void om(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.i
 * JD-Core Version:    0.7.0.1
 */