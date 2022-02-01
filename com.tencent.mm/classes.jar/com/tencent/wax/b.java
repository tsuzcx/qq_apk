package com.tencent.wax;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.f;

public final class b
  extends io.flutter.app.c
{
  private io.flutter.embedding.engine.a cPI;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cPI = parama;
  }
  
  public final m.c er(String paramString)
  {
    AppMethodBeat.i(195482);
    paramString = new a(super.er(paramString));
    AppMethodBeat.o(195482);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cPJ;
    
    public a(m.c paramc)
    {
      this.cPJ = paramc;
    }
    
    public final Activity JY()
    {
      AppMethodBeat.i(195475);
      Activity localActivity;
      if (this.cPJ.JY() != null)
      {
        localActivity = this.cPJ.JY();
        AppMethodBeat.o(195475);
        return localActivity;
      }
      if (d.gdr().MHD != null)
      {
        localActivity = d.gdr().MHD.getActivity();
        AppMethodBeat.o(195475);
        return localActivity;
      }
      AppMethodBeat.o(195475);
      return null;
    }
    
    public final Context JZ()
    {
      AppMethodBeat.i(195476);
      Context localContext = this.cPJ.JZ();
      AppMethodBeat.o(195476);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c Ka()
    {
      AppMethodBeat.i(195477);
      DartExecutor localDartExecutor = b.a(b.this).MZm;
      AppMethodBeat.o(195477);
      return localDartExecutor;
    }
    
    public final io.flutter.view.c Kb()
    {
      AppMethodBeat.i(195478);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).MYh;
      AppMethodBeat.o(195478);
      return locala;
    }
    
    public final String L(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195480);
      paramString1 = this.cPJ.L(paramString1, paramString2);
      AppMethodBeat.o(195480);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(195481);
      paramf = this.cPJ.a(paramf);
      AppMethodBeat.o(195481);
      return paramf;
    }
    
    public final String es(String paramString)
    {
      AppMethodBeat.i(195479);
      paramString = this.cPJ.es(paramString);
      AppMethodBeat.o(195479);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.b
 * JD-Core Version:    0.7.0.1
 */