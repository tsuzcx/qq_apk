package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "mMultiTaskRecycleView", "Landroid/support/v7/widget/RecyclerView;", "mPreTransY", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setMultiTaskRecyclerView", "recyclerView", "smoothScrollToPosition", "Companion", "ui-multitask_release"})
public class MinusScreenGridLayoutManager
  extends GridLayoutManager
{
  public static final a AdO;
  public RecyclerView AdM;
  private float AdN;
  
  static
  {
    AppMethodBeat.i(236447);
    AdO = new a((byte)0);
    AppMethodBeat.o(236447);
  }
  
  public MinusScreenGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
  }
  
  public final void ah(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236445);
    super.ah(paramInt1, paramInt2);
    AppMethodBeat.o(236445);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(236441);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(236441);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(236441);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(236446);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("lo", new Class[0]);
      p.g(localMethod, "RecyclerView::class.java…arkItemDecorInsetsDirty\")");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      p.g(localObject, "RecyclerView.LayoutManag…redField(\"mRecyclerView\")");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        Log.i("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(236446);
        return;
      }
      AppMethodBeat.o(236446);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(236446);
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(236444);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(236444);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(236442);
    RecyclerView localRecyclerView = this.AdM;
    if (localRecyclerView != null) {}
    for (float f = localRecyclerView.getTranslationY(); (f != 0.0F) && (this.AdN * f >= 0.0F); f = 0.0F)
    {
      this.AdN = f;
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.AdN);
      AppMethodBeat.o(236442);
      return 0;
    }
    if (f == 0.0F) {
      this.AdN = 0.0F;
    }
    for (;;)
    {
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.AdN);
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(236442);
      return paramInt;
      if (this.AdN * f < 0.0F)
      {
        localRecyclerView = this.AdM;
        if (localRecyclerView != null) {
          localRecyclerView.setTranslationY(0.0F);
        }
        this.AdN = f;
      }
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(236443);
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(236443);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */