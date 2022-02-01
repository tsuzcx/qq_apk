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
  private io.flutter.embedding.engine.a cOY;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cOY = parama;
  }
  
  public final m.c em(String paramString)
  {
    AppMethodBeat.i(217479);
    paramString = new a(super.em(paramString));
    AppMethodBeat.o(217479);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cOZ;
    
    public a(m.c paramc)
    {
      this.cOZ = paramc;
    }
    
    public final Activity JQ()
    {
      AppMethodBeat.i(217472);
      if (this.cOZ.JQ() != null)
      {
        localActivity = this.cOZ.JQ();
        AppMethodBeat.o(217472);
        return localActivity;
      }
      Activity localActivity = d.fYR().MkG;
      AppMethodBeat.o(217472);
      return localActivity;
    }
    
    public final Context JR()
    {
      AppMethodBeat.i(217473);
      Context localContext = this.cOZ.JR();
      AppMethodBeat.o(217473);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c JS()
    {
      AppMethodBeat.i(217474);
      DartExecutor localDartExecutor = b.a(b.this).MCh;
      AppMethodBeat.o(217474);
      return localDartExecutor;
    }
    
    public final io.flutter.view.c JT()
    {
      AppMethodBeat.i(217475);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).MBc;
      AppMethodBeat.o(217475);
      return locala;
    }
    
    public final String L(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217477);
      paramString1 = this.cOZ.L(paramString1, paramString2);
      AppMethodBeat.o(217477);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(217478);
      paramf = this.cOZ.a(paramf);
      AppMethodBeat.o(217478);
      return paramf;
    }
    
    public final String en(String paramString)
    {
      AppMethodBeat.i(217476);
      paramString = this.cOZ.en(paramString);
      AppMethodBeat.o(217476);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.b
 * JD-Core Version:    0.7.0.1
 */