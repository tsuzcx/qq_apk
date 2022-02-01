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
  private io.flutter.embedding.engine.a cDT;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cDT = parama;
  }
  
  public final m.c dq(String paramString)
  {
    AppMethodBeat.i(191682);
    paramString = new a(super.dq(paramString));
    AppMethodBeat.o(191682);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cDU;
    
    public a(m.c paramc)
    {
      this.cDU = paramc;
    }
    
    public final Activity Iq()
    {
      AppMethodBeat.i(191675);
      if (this.cDU.Iq() != null)
      {
        localActivity = this.cDU.Iq();
        AppMethodBeat.o(191675);
        return localActivity;
      }
      Activity localActivity = d.fHA().KuF;
      AppMethodBeat.o(191675);
      return localActivity;
    }
    
    public final Context Ir()
    {
      AppMethodBeat.i(191676);
      Context localContext = this.cDU.Ir();
      AppMethodBeat.o(191676);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c Is()
    {
      AppMethodBeat.i(191677);
      DartExecutor localDartExecutor = b.a(b.this).KLk;
      AppMethodBeat.o(191677);
      return localDartExecutor;
    }
    
    public final io.flutter.view.c It()
    {
      AppMethodBeat.i(191678);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).KKo;
      AppMethodBeat.o(191678);
      return locala;
    }
    
    public final String K(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191680);
      paramString1 = this.cDU.K(paramString1, paramString2);
      AppMethodBeat.o(191680);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(191681);
      paramf = this.cDU.a(paramf);
      AppMethodBeat.o(191681);
      return paramf;
    }
    
    public final String dr(String paramString)
    {
      AppMethodBeat.i(191679);
      paramString = this.cDU.dr(paramString);
      AppMethodBeat.o(191679);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.b
 * JD-Core Version:    0.7.0.1
 */