package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.o;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  private k aKT;
  public final boolean aatC;
  public byte[] aatD;
  k.d aatE;
  boolean aatF;
  boolean aatG;
  private final k.c aatH;
  
  public j(DartExecutor paramDartExecutor, boolean paramBoolean)
  {
    this(new k(paramDartExecutor, "flutter/restoration", o.aauS), paramBoolean);
    AppMethodBeat.i(253473);
    AppMethodBeat.o(253473);
  }
  
  private j(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(253477);
    this.aatF = false;
    this.aatG = false;
    this.aatH = new k.c()
    {
      public final void a(io.flutter.plugin.a.j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(253293);
        String str = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.ZZe;
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
            AppMethodBeat.o(253293);
            return;
            if (str.equals("put"))
            {
              i = 0;
              continue;
              if (str.equals("get")) {
                i = 1;
              }
            }
            break;
          }
        }
        j.this.aatD = ((byte[])paramAnonymousj);
        paramAnonymousd.bb(null);
        AppMethodBeat.o(253293);
        return;
        j.this.aatG = true;
        if ((j.this.aatF) || (!j.this.aatC))
        {
          paramAnonymousd.bb(j.dC(j.this.aatD));
          AppMethodBeat.o(253293);
          return;
        }
        j.this.aatE = paramAnonymousd;
        AppMethodBeat.o(253293);
      }
    };
    this.aKT = paramk;
    this.aatC = paramBoolean;
    paramk.a(this.aatH);
    AppMethodBeat.o(253477);
  }
  
  static Map<String, Object> dC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(253483);
    HashMap localHashMap = new HashMap();
    localHashMap.put("enabled", Boolean.TRUE);
    localHashMap.put("data", paramArrayOfByte);
    AppMethodBeat.o(253483);
    return localHashMap;
  }
  
  public final void dB(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(253480);
    this.aatF = true;
    if (this.aatE != null)
    {
      this.aatE.bb(dC(paramArrayOfByte));
      this.aatE = null;
    }
    while (!this.aatG)
    {
      this.aatD = paramArrayOfByte;
      AppMethodBeat.o(253480);
      return;
    }
    this.aKT.a("push", dC(paramArrayOfByte), new k.d()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(253716);
        new StringBuilder("Error ").append(paramAnonymousString1).append(" while sending restoration data to framework: ").append(paramAnonymousString2);
        b.iAh();
        AppMethodBeat.o(253716);
      }
      
      public final void bb(Object paramAnonymousObject)
      {
        j.this.aatD = paramArrayOfByte;
      }
      
      public final void epZ() {}
    });
    AppMethodBeat.o(253480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.j
 * JD-Core Version:    0.7.0.1
 */