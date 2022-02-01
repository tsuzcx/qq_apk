package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  private final k aKT;
  Map<String, List<k.d>> aasp;
  final k.c aasq;
  public DeferredComponentManager deferredComponentManager;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(254948);
    this.aasq = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(255220);
        if (b.this.deferredComponentManager == null)
        {
          AppMethodBeat.o(255220);
          return;
        }
        String str = paramAnonymousj.method;
        paramAnonymousj = (Map)paramAnonymousj.ZZe;
        new StringBuilder("Received '").append(str).append("' message.");
        io.flutter.b.iAd();
        int j = ((Integer)paramAnonymousj.get("loadingUnitId")).intValue();
        paramAnonymousj = (String)paramAnonymousj.get("moduleName");
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
            AppMethodBeat.o(255220);
            return;
            if (str.equals("installDeferredComponent"))
            {
              i = 0;
              continue;
              if (str.equals("getDeferredComponentInstallState"))
              {
                i = 1;
                continue;
                if (str.equals("uninstallDeferredComponent")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        b.this.deferredComponentManager.dE(j, paramAnonymousj);
        if (!b.this.aasp.containsKey(paramAnonymousj)) {
          b.this.aasp.put(paramAnonymousj, new ArrayList());
        }
        ((List)b.this.aasp.get(paramAnonymousj)).add(paramAnonymousd);
        AppMethodBeat.o(255220);
        return;
        paramAnonymousd.bb(b.this.deferredComponentManager.dF(j, paramAnonymousj));
        AppMethodBeat.o(255220);
        return;
        b.this.deferredComponentManager.dG(j, paramAnonymousj);
        paramAnonymousd.bb(null);
        AppMethodBeat.o(255220);
      }
    };
    this.aKT = new k(paramDartExecutor, "flutter/deferredcomponent", o.aauS);
    this.aKT.a(this.aasq);
    this.deferredComponentManager = a.iAc().deferredComponentManager;
    this.aasp = new HashMap();
    AppMethodBeat.o(254948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.b
 * JD-Core Version:    0.7.0.1
 */