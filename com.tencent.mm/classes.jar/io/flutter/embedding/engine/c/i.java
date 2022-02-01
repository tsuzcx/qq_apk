package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.o;

public final class i
{
  public final boolean SRd;
  public byte[] SRe;
  k.d SRf;
  boolean SRg;
  boolean SRh;
  private final k.c SRi;
  private k bbv;
  
  public i(DartExecutor paramDartExecutor, boolean paramBoolean)
  {
    this(new k(paramDartExecutor, "flutter/restoration", o.SSr), paramBoolean);
    AppMethodBeat.i(214993);
    AppMethodBeat.o(214993);
  }
  
  private i(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(214994);
    this.SRg = false;
    this.SRh = false;
    this.SRi = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(214989);
        String str = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.SxX;
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
            AppMethodBeat.o(214989);
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
        i.this.SRe = ((byte[])paramAnonymousj);
        paramAnonymousd.ba(null);
        AppMethodBeat.o(214989);
        return;
        i.this.SRh = true;
        if ((i.this.SRg) || (!i.this.SRd))
        {
          paramAnonymousd.ba(i.this.SRe);
          AppMethodBeat.o(214989);
          return;
        }
        i.this.SRf = paramAnonymousd;
        AppMethodBeat.o(214989);
      }
    };
    this.bbv = paramk;
    this.SRd = paramBoolean;
    paramk.a(this.SRi);
    AppMethodBeat.o(214994);
  }
  
  public final void de(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214995);
    this.SRg = true;
    if (this.SRf != null)
    {
      this.SRf.ba(paramArrayOfByte);
      this.SRf = null;
    }
    while (!this.SRh)
    {
      this.SRe = paramArrayOfByte;
      AppMethodBeat.o(214995);
      return;
    }
    this.bbv.a("push", paramArrayOfByte, new k.d()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(214988);
        new StringBuilder("Error ").append(paramAnonymousString1).append(" while sending restoration data to framework: ").append(paramAnonymousString2);
        a.hwg();
        AppMethodBeat.o(214988);
      }
      
      public final void ba(Object paramAnonymousObject)
      {
        i.this.SRe = paramArrayOfByte;
      }
      
      public final void dLv() {}
    });
    AppMethodBeat.o(214995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.i
 * JD-Core Version:    0.7.0.1
 */