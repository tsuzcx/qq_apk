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
  public d KNM;
  private final k.c KNN;
  public final k uzK;
  
  public g(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.KNN = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (g.this.KNM == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        a.fMD();
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
            paramAnonymousd.daE();
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
        paramAnonymousj = (Map)paramAnonymousj.fXJ;
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
            paramAnonymousd.db(Long.valueOf(g.this.KNM.a(paramAnonymousj)));
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            paramAnonymousd.e("error", g.q(paramAnonymousj), null);
            AppMethodBeat.o(10241);
            return;
          }
        }
        i = ((Integer)paramAnonymousj.fXJ).intValue();
        try
        {
          g.this.KNM.agz(i);
          paramAnonymousd.db(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.e("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.fXJ;
        paramAnonymousj = new g.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          g.this.KNM.a(paramAnonymousj, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(10253);
              paramAnonymousd.db(null);
              AppMethodBeat.o(10253);
            }
          });
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.e("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (List)paramAnonymousj.fXJ;
        paramAnonymousj = new g.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue());
        try
        {
          g.this.KNM.a(paramAnonymousj);
          paramAnonymousd.db(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.e("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.fXJ;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          g.this.KNM.kU(i, j);
          paramAnonymousd.db(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.e("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.fXJ).intValue();
        try
        {
          g.this.KNM.agA(i);
          paramAnonymousd.db(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.e("error", g.q(paramAnonymousj), null);
          AppMethodBeat.o(10241);
        }
      }
    };
    this.uzK = new k(paramDartExecutor, "flutter/platform_views", o.KPd);
    this.uzK.a(this.KNN);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String KNQ;
    public final double KNR;
    public final double KNS;
    public final ByteBuffer KNT;
    public final int direction;
    public final int viewId;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.KNQ = paramString;
      this.KNR = paramDouble1;
      this.KNS = paramDouble2;
      this.direction = paramInt2;
      this.KNT = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double KNU;
    public final double KNV;
    public final int viewId;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.KNU = paramDouble1;
      this.KNV = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final int KMY;
    public final Number KNW;
    public final Number KNX;
    public final Object KNY;
    public final Object KNZ;
    public final int KNd;
    public final int KOa;
    public final float KOb;
    public final float KOc;
    public final int action;
    public final int dbL;
    public final int edgeFlags;
    public final int flags;
    public final int jcl;
    public final int viewId;
    
    c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.viewId = paramInt1;
      this.KNW = paramNumber1;
      this.KNX = paramNumber2;
      this.action = paramInt2;
      this.jcl = paramInt3;
      this.KNY = paramObject1;
      this.KNZ = paramObject2;
      this.KNd = paramInt4;
      this.KOa = paramInt5;
      this.KOb = paramFloat1;
      this.KOc = paramFloat2;
      this.KMY = paramInt6;
      this.edgeFlags = paramInt7;
      this.dbL = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface d
  {
    public abstract long a(g.a parama);
    
    public abstract void a(g.b paramb, Runnable paramRunnable);
    
    public abstract void a(g.c paramc);
    
    public abstract void agA(int paramInt);
    
    public abstract void agz(int paramInt);
    
    public abstract void kU(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g
 * JD-Core Version:    0.7.0.1
 */