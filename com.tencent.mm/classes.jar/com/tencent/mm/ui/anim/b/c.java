package com.tencent.mm.ui.anim.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/basic/SpringScale;", "Lcom/tencent/mm/ui/anim/basic/SpringProperty;", "()V", "get", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "Landroid/view/View;", "minimumVisibleChange", "", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public static final c adMn;
  
  static
  {
    AppMethodBeat.i(251186);
    adMn = new c();
    AppMethodBeat.o(251186);
  }
  
  private c()
  {
    super((byte)0);
  }
  
  public final androidx.e.a.c<View> jly()
  {
    AppMethodBeat.i(251193);
    androidx.e.a.c localc = (androidx.e.a.c)new a();
    AppMethodBeat.o(251193);
    return localc;
  }
  
  public final float jlz()
  {
    return 0.002F;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/anim/basic/SpringScale$get$scale$1", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "Landroid/view/View;", "getValue", "", "view", "setValue", "", "value", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends androidx.e.a.c<View>
  {
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.anim.b.c
 * JD-Core Version:    0.7.0.1
 */