package com.tencent.mm.ui.widget.pulldown;

import com.g.a.a.a.a;
import com.g.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceParam;", "", "()V", "DECELERATE_RATIO_DEFAULT", "", "MAX_BOUNCE_BACK_DURATION_MS_DEFAULT", "", "MAX_DAMPING_FACTOR", "MIN_BOUNCE_BACK_DURATION_MS_DEFAULT", "MIN_DAMPING_FACTOR", "curMode", "getCurMode", "()I", "setCurMode", "(I)V", "decelerateRatio", "getDecelerateRatio", "()F", "setDecelerateRatio", "(F)V", "isPullDownDebugOpen", "", "()Z", "setPullDownDebugOpen", "(Z)V", "maxDampingFactor", "getMaxDampingFactor", "setMaxDampingFactor", "maxSpringDuration", "getMaxSpringDuration", "setMaxSpringDuration", "minDampingFactor", "getMinDampingFactor", "setMinDampingFactor", "minSpringDuration", "getMinSpringDuration", "setMinSpringDuration", "overScrollMode1", "Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "getOverScrollMode1", "()Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "overScrollMode2", "Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "getOverScrollMode2", "()Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "getOverScrollMode", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j aglL;
  private static float aglM;
  private static int aglN;
  private static int aglO;
  private static int aglP;
  private static int aglQ;
  private static final a aglR;
  private static final b aglS;
  private static boolean aglT;
  private static int niy;
  
  static
  {
    AppMethodBeat.i(252009);
    aglL = new j();
    aglM = 1.0F;
    aglN = 800;
    aglO = 400;
    aglP = 1;
    aglQ = 8;
    aglR = new a();
    aglS = new b();
    AppMethodBeat.o(252009);
  }
  
  public static void NK(boolean paramBoolean)
  {
    aglT = paramBoolean;
  }
  
  public static void aFt(int paramInt)
  {
    aglN = paramInt;
  }
  
  public static void aFu(int paramInt)
  {
    aglO = paramInt;
  }
  
  public static void aFv(int paramInt)
  {
    aglP = paramInt;
  }
  
  public static void aFw(int paramInt)
  {
    aglQ = paramInt;
  }
  
  public static void aFx(int paramInt)
  {
    niy = paramInt;
  }
  
  public static void ek(float paramFloat)
  {
    aglM = paramFloat;
  }
  
  public static float jIQ()
  {
    return aglM;
  }
  
  public static int jIR()
  {
    return aglN;
  }
  
  public static int jIS()
  {
    return aglO;
  }
  
  public static int jIT()
  {
    return aglP;
  }
  
  public static int jIU()
  {
    return aglQ;
  }
  
  public static int jIV()
  {
    return niy;
  }
  
  public static boolean jIW()
  {
    return aglT;
  }
  
  public static h jIX()
  {
    if (niy == 1) {
      return (h)aglS;
    }
    return (h)aglR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.j
 * JD-Core Version:    0.7.0.1
 */