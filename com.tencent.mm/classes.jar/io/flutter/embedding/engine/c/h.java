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

public final class h
{
  public d SQK;
  private final k.c SQL;
  public final k bbv;
  
  public h(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10271);
    this.SQL = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(10241);
        if (h.this.SQK == null)
        {
          AppMethodBeat.o(10241);
          return;
        }
        new StringBuilder("Received '").append(paramAnonymousj.method).append("' message.");
        a.hwd();
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
            paramAnonymousd.dLv();
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
        paramAnonymousj = (Map)paramAnonymousj.SxX;
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
          paramAnonymousj = new h.a(j, str, d1, d2, k, paramAnonymousj);
          if (i == 0) {
            break label516;
          }
          try
          {
            h.this.SQK.a(paramAnonymousj);
            paramAnonymousd.ba(null);
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            paramAnonymousd.b("error", h.s(paramAnonymousj), null);
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
        paramAnonymousd.ba(Long.valueOf(h.this.SQK.b(paramAnonymousj)));
        AppMethodBeat.o(10241);
        return;
        paramAnonymousj = (Map)paramAnonymousj.SxX;
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
            h.this.SQK.att(j);
            paramAnonymousd.ba(null);
            AppMethodBeat.o(10241);
            return;
          }
          catch (IllegalStateException paramAnonymousj)
          {
            label639:
            paramAnonymousd.b("error", h.s(paramAnonymousj), null);
            AppMethodBeat.o(10241);
            return;
          }
          i = 0;
          break;
          h.this.SQK.atu(j);
        }
        paramAnonymousj = (Map)paramAnonymousj.SxX;
        paramAnonymousj = new h.b(((Integer)paramAnonymousj.get("id")).intValue(), ((Double)paramAnonymousj.get("width")).doubleValue(), ((Double)paramAnonymousj.get("height")).doubleValue());
        try
        {
          h.this.SQK.a(paramAnonymousj, new h.1.1(this, paramAnonymousd));
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", h.s(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (List)paramAnonymousj.SxX;
        paramAnonymousj = new h.c(((Integer)paramAnonymousj.get(0)).intValue(), (Number)paramAnonymousj.get(1), (Number)paramAnonymousj.get(2), ((Integer)paramAnonymousj.get(3)).intValue(), ((Integer)paramAnonymousj.get(4)).intValue(), paramAnonymousj.get(5), paramAnonymousj.get(6), ((Integer)paramAnonymousj.get(7)).intValue(), ((Integer)paramAnonymousj.get(8)).intValue(), (float)((Double)paramAnonymousj.get(9)).doubleValue(), (float)((Double)paramAnonymousj.get(10)).doubleValue(), ((Integer)paramAnonymousj.get(11)).intValue(), ((Integer)paramAnonymousj.get(12)).intValue(), ((Integer)paramAnonymousj.get(13)).intValue(), ((Integer)paramAnonymousj.get(14)).intValue(), ((Number)paramAnonymousj.get(15)).longValue());
        try
        {
          h.this.SQK.a(paramAnonymousj);
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", h.s(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        paramAnonymousj = (Map)paramAnonymousj.SxX;
        i = ((Integer)paramAnonymousj.get("id")).intValue();
        j = ((Integer)paramAnonymousj.get("direction")).intValue();
        try
        {
          h.this.SQK.mT(i, j);
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", h.s(paramAnonymousj), null);
          AppMethodBeat.o(10241);
          return;
        }
        i = ((Integer)paramAnonymousj.SxX).intValue();
        try
        {
          h.this.SQK.atv(i);
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10241);
          return;
        }
        catch (IllegalStateException paramAnonymousj)
        {
          paramAnonymousd.b("error", h.s(paramAnonymousj), null);
          AppMethodBeat.o(10241);
        }
      }
    };
    this.bbv = new k(paramDartExecutor, "flutter/platform_views", o.SSr);
    this.bbv.a(this.SQL);
    AppMethodBeat.o(10271);
  }
  
  public static final class a
  {
    public final String SQP;
    public final double SQQ;
    public final double SQR;
    public final ByteBuffer SQS;
    public final int direction;
    public final int viewId;
    
    public a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.SQP = paramString;
      this.SQQ = paramDouble1;
      this.SQR = paramDouble2;
      this.direction = paramInt2;
      this.SQS = paramByteBuffer;
    }
  }
  
  public static final class b
  {
    public final double SQT;
    public final double SQU;
    public final int viewId;
    
    public b(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.SQT = paramDouble1;
      this.SQU = paramDouble2;
    }
  }
  
  public static final class c
  {
    public final int SPU;
    public final int SPZ;
    public final Number SQV;
    public final Number SQW;
    public final Object SQX;
    public final Object SQY;
    public final int SQZ;
    public final float SRa;
    public final float SRb;
    public final long SRc;
    public final int action;
    public final int edgeFlags;
    public final int flags;
    public final int kyY;
    public final int source;
    public final int viewId;
    
    public c(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong)
    {
      this.viewId = paramInt1;
      this.SQV = paramNumber1;
      this.SQW = paramNumber2;
      this.action = paramInt2;
      this.kyY = paramInt3;
      this.SQX = paramObject1;
      this.SQY = paramObject2;
      this.SPZ = paramInt4;
      this.SQZ = paramInt5;
      this.SRa = paramFloat1;
      this.SRb = paramFloat2;
      this.SPU = paramInt6;
      this.edgeFlags = paramInt7;
      this.source = paramInt8;
      this.flags = paramInt9;
      this.SRc = paramLong;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(h.a parama);
    
    public abstract void a(h.b paramb, Runnable paramRunnable);
    
    public abstract void a(h.c paramc);
    
    public abstract void att(int paramInt);
    
    public abstract void atu(int paramInt);
    
    public abstract void atv(int paramInt);
    
    public abstract long b(h.a parama);
    
    public abstract void mT(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.h
 * JD-Core Version:    0.7.0.1
 */