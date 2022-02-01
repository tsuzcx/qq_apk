package com.tencent.mm.ui.anim.e;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/interpolator/InterpolatorProvider;", "", "()V", "default", "Landroid/view/animation/Interpolator;", "getDefault", "()Landroid/view/animation/Interpolator;", "default$delegate", "Lkotlin/Lazy;", "easeBoth", "getEaseBoth", "easeBoth$delegate", "easeIn", "getEaseIn", "easeIn$delegate", "easeOut", "getEaseOut", "easeOut$delegate", "isEaseOpenForPage", "", "()Z", "setEaseOpenForPage", "(Z)V", "linear", "getLinear", "linear$delegate", "initView", "", "view", "Landroid/view/View;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c adMR;
  public static boolean adMS;
  private static final j adMT;
  private static final j adMU;
  private static final j adMV;
  private static final j adMW;
  private static final j default$delegate;
  
  static
  {
    AppMethodBeat.i(251218);
    adMR = new c();
    adMT = k.cm((a)e.adNb);
    default$delegate = k.cm((a)a.adMX);
    adMU = k.cm((a)c.adMZ);
    adMV = k.cm((a)d.adNa);
    adMW = k.cm((a)b.adMY);
    AppMethodBeat.o(251218);
  }
  
  public static Interpolator jlL()
  {
    AppMethodBeat.i(251208);
    Interpolator localInterpolator = (Interpolator)default$delegate.getValue();
    AppMethodBeat.o(251208);
    return localInterpolator;
  }
  
  public static Interpolator jlM()
  {
    AppMethodBeat.i(251214);
    Interpolator localInterpolator = (Interpolator)adMV.getValue();
    AppMethodBeat.o(251214);
    return localInterpolator;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/PathInterpolator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<PathInterpolator>
  {
    public static final a adMX;
    
    static
    {
      AppMethodBeat.i(251203);
      adMX = new a();
      AppMethodBeat.o(251203);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/PathInterpolator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<PathInterpolator>
  {
    public static final b adMY;
    
    static
    {
      AppMethodBeat.i(251207);
      adMY = new b();
      AppMethodBeat.o(251207);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/PathInterpolator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<PathInterpolator>
  {
    public static final c adMZ;
    
    static
    {
      AppMethodBeat.i(251212);
      adMZ = new c();
      AppMethodBeat.o(251212);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/PathInterpolator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<PathInterpolator>
  {
    public static final d adNa;
    
    static
    {
      AppMethodBeat.i(251205);
      adNa = new d();
      AppMethodBeat.o(251205);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/LinearInterpolator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<LinearInterpolator>
  {
    public static final e adNb;
    
    static
    {
      AppMethodBeat.i(251206);
      adNb = new e();
      AppMethodBeat.o(251206);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.anim.e.c
 * JD-Core Version:    0.7.0.1
 */