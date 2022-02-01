package com.tencent.mm.ui.anim.content;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "", "cancel", "", "enable", "enabled", "", "onLayoutAfter", "changed", "left", "", "top", "right", "bottom", "onMeasureAfter", "Lkotlin/Pair;", "widthMeasureSpec", "heightMeasureSpec", "onMeasureBefore", "pause", "requestGone", "requestVisible", "resume", "setSizeAnimListener", "listener", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController$SizeAnimListener;", "Companion", "SizeAnimListener", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public static final a adMs = a.adMt;
  
  public abstract void Lw(boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void cancel();
  
  public abstract void pause();
  
  public abstract void resume();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/ISizeAnimController$Companion;", "", "()V", "NULL", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "getNULL", "()Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final b adMu;
    
    static
    {
      AppMethodBeat.i(251235);
      adMt = new a();
      adMu = (b)new a();
      AppMethodBeat.o(251235);
    }
    
    public static b jlA()
    {
      return adMu;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/anim/content/ISizeAnimController$Companion$NULL$1", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "cancel", "", "enable", "enabled", "", "onLayoutAfter", "changed", "left", "", "top", "right", "bottom", "onMeasureAfter", "Lkotlin/Pair;", "widthMeasureSpec", "heightMeasureSpec", "onMeasureBefore", "pause", "requestGone", "requestVisible", "resume", "setSizeAnimListener", "listener", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController$SizeAnimListener;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b
    {
      public final void Lw(boolean paramBoolean) {}
      
      public final void a(b.b paramb) {}
      
      public final void cancel() {}
      
      public final void pause() {}
      
      public final void resume() {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/ISizeAnimController$SizeAnimListener;", "", "onSizeAnim", "", "key", "", "isInAnim", "", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void cE(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.anim.content.b
 * JD-Core Version:    0.7.0.1
 */