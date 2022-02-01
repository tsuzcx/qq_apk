package com.tencent.mm.ui.widget.pulldown;

import com.c.a.a.a.a;
import com.c.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceParam;", "", "()V", "DECELERATE_RATIO_DEFAULT", "", "MAX_BOUNCE_BACK_DURATION_MS_DEFAULT", "", "MAX_DAMPING_FACTOR", "MIN_BOUNCE_BACK_DURATION_MS_DEFAULT", "MIN_DAMPING_FACTOR", "curMode", "getCurMode", "()I", "setCurMode", "(I)V", "decelerateRatio", "getDecelerateRatio", "()F", "setDecelerateRatio", "(F)V", "isPullDownDebugOpen", "", "()Z", "setPullDownDebugOpen", "(Z)V", "maxDampingFactor", "getMaxDampingFactor", "setMaxDampingFactor", "maxSpringDuration", "getMaxSpringDuration", "setMaxSpringDuration", "minDampingFactor", "getMinDampingFactor", "setMinDampingFactor", "minSpringDuration", "getMinSpringDuration", "setMinSpringDuration", "overScrollMode1", "Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "getOverScrollMode1", "()Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode1;", "overScrollMode2", "Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "getOverScrollMode2", "()Lcom/soon/xanimexample/scroll/pulldown/OverScrollMode2;", "getOverScrollMode", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "weui-native-android-lib_release"})
public final class i
{
  private static int YtA;
  private static int YtB;
  private static int YtC;
  private static int YtD;
  private static final a YtE;
  private static final b YtF;
  private static boolean YtG;
  public static final i YtH;
  private static float Ytz;
  private static int kFs;
  
  static
  {
    AppMethodBeat.i(251998);
    YtH = new i();
    Ytz = 1.0F;
    YtA = 800;
    YtB = 400;
    YtC = 1;
    YtD = 8;
    YtE = new a();
    YtF = new b();
    AppMethodBeat.o(251998);
  }
  
  public static void HP(boolean paramBoolean)
  {
    YtG = paramBoolean;
  }
  
  public static void ayN(int paramInt)
  {
    YtA = paramInt;
  }
  
  public static void ayO(int paramInt)
  {
    YtB = paramInt;
  }
  
  public static void ayP(int paramInt)
  {
    YtC = paramInt;
  }
  
  public static void ayQ(int paramInt)
  {
    YtD = paramInt;
  }
  
  public static void ayR(int paramInt)
  {
    kFs = paramInt;
  }
  
  public static void cW(float paramFloat)
  {
    Ytz = paramFloat;
  }
  
  public static float idI()
  {
    return Ytz;
  }
  
  public static int idJ()
  {
    return YtA;
  }
  
  public static int idK()
  {
    return YtB;
  }
  
  public static int idL()
  {
    return YtC;
  }
  
  public static int idM()
  {
    return YtD;
  }
  
  public static int idN()
  {
    return kFs;
  }
  
  public static boolean idO()
  {
    return YtG;
  }
  
  public static f idP()
  {
    switch (kFs)
    {
    default: 
      return (f)YtE;
    }
    return (f)YtF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.i
 * JD-Core Version:    0.7.0.1
 */