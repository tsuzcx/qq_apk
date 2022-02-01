package io.flutter.embedding.engine.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class d
{
  public final k bbv;
  
  public d(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10222);
    this.bbv = new k(paramDartExecutor, "flutter/localization", g.SSl);
    AppMethodBeat.o(10222);
  }
  
  public final void km(List<Locale> paramList)
  {
    AppMethodBeat.i(10223);
    a.hwd();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Locale localLocale = (Locale)localIterator.next();
      new StringBuilder("Locale (Language: ").append(localLocale.getLanguage()).append(", Country: ").append(localLocale.getCountry()).append(", Variant: ").append(localLocale.getVariant()).append(")");
      a.hwd();
      localArrayList.add(localLocale.getLanguage());
      localArrayList.add(localLocale.getCountry());
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramList = localLocale.getScript();; paramList = "")
      {
        localArrayList.add(paramList);
        localArrayList.add(localLocale.getVariant());
        break;
      }
    }
    this.bbv.a("setLocale", localArrayList, null);
    AppMethodBeat.o(10223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.c.d
 * JD-Core Version:    0.7.0.1
 */