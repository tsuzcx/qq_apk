package io.flutter.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import java.io.File;

public final class a
  implements k.c
{
  private final m.c JcH;
  
  public a(m.c paramc)
  {
    this.JcH = paramc;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(153351);
    paramj = paramj.method;
    int i = -1;
    switch (paramj.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.Av();
        AppMethodBeat.o(153351);
        return;
        if (paramj.equals("getTemporaryDirectory"))
        {
          i = 0;
          continue;
          if (paramj.equals("getApplicationDocumentsDirectory"))
          {
            i = 1;
            continue;
            if (paramj.equals("getStorageDirectory")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramd.ay(this.JcH.II().getCacheDir().getPath());
    AppMethodBeat.o(153351);
    return;
    paramd.ay(this.JcH.II().getDir("flutter", 0).getPath());
    AppMethodBeat.o(153351);
    return;
    paramd.ay(this.JcH.II().getExternalFilesDir(null).getAbsolutePath());
    AppMethodBeat.o(153351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.b.a.a
 * JD-Core Version:    0.7.0.1
 */