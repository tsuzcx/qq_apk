package com.tencent.mm.plugin.surface.c;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "devicePixelRatio", "", "getDevicePixelRatio", "()F", "devicePixelRatio$delegate", "Lkotlin/Lazy;", "viewportHeight", "", "getViewportHeight", "()I", "viewportWidth", "getViewportWidth", "fromPixel", "", "toPixel", "plugin-surface-app_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final j SLt;
  
  static
  {
    AppMethodBeat.i(265068);
    SLt = k.cm((kotlin.g.a.a)a.SLu);
    AppMethodBeat.o(265068);
  }
  
  public static final int d(Number paramNumber)
  {
    AppMethodBeat.i(265033);
    s.u(paramNumber, "<this>");
    int i = kotlin.h.a.eH(paramNumber.floatValue() * getDevicePixelRatio());
    AppMethodBeat.o(265033);
    return i;
  }
  
  public static final int e(Number paramNumber)
  {
    AppMethodBeat.i(265040);
    s.u(paramNumber, "<this>");
    int i = kotlin.h.a.eH(paramNumber.floatValue() / getDevicePixelRatio());
    AppMethodBeat.o(265040);
    return i;
  }
  
  public static final Context getAppContext()
  {
    AppMethodBeat.i(265030);
    Context localContext = MMApplicationContext.getContext().getApplicationContext();
    s.s(localContext, "getContext().applicationContext");
    AppMethodBeat.o(265030);
    return localContext;
  }
  
  public static final float getDevicePixelRatio()
  {
    AppMethodBeat.i(265047);
    float f = ((Number)SLt.getValue()).floatValue();
    AppMethodBeat.o(265047);
    return f;
  }
  
  public static final int hBY()
  {
    AppMethodBeat.i(265057);
    Object localObject = getAppContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(265057);
      throw ((Throwable)localObject);
    }
    int i = e((Number)Integer.valueOf(((WindowManager)localObject).getDefaultDisplay().getWidth()));
    AppMethodBeat.o(265057);
    return i;
  }
  
  public static final int hBZ()
  {
    AppMethodBeat.i(265063);
    Object localObject = getAppContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(265063);
      throw ((Throwable)localObject);
    }
    int i = e((Number)Integer.valueOf(((WindowManager)localObject).getDefaultDisplay().getHeight()));
    AppMethodBeat.o(265063);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Float>
  {
    public static final a SLu;
    
    static
    {
      AppMethodBeat.i(265022);
      SLu = new a();
      AppMethodBeat.o(265022);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.h
 * JD-Core Version:    0.7.0.1
 */