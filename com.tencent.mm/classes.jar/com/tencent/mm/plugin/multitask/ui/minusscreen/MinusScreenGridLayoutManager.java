package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "mMultiTaskRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mPreTransY", "", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setMultiTaskRecyclerView", "recyclerView", "smoothScrollToPosition", "Companion", "ui-multitask_release"})
public class MinusScreenGridLayoutManager
  extends GridLayoutManager
{
  public static final a FKr;
  public RecyclerView FKp;
  private float FKq;
  
  static
  {
    AppMethodBeat.i(197553);
    FKr = new a((byte)0);
    AppMethodBeat.o(197553);
  }
  
  public MinusScreenGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197551);
    super.au(paramInt1, paramInt2);
    AppMethodBeat.o(197551);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(197543);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(197543);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(197543);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(197552);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("lB", new Class[0]);
      p.j(localMethod, "RecyclerView::class.java…arkItemDecorInsetsDirty\")");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      p.j(localObject, "RecyclerView.LayoutManag…redField(\"mRecyclerView\")");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        Log.i("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(197552);
        return;
      }
      AppMethodBeat.o(197552);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(197552);
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(197550);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(197550);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(197547);
    RecyclerView localRecyclerView = this.FKp;
    if (localRecyclerView != null) {}
    for (float f = localRecyclerView.getTranslationY(); (f != 0.0F) && (this.FKq * f >= 0.0F); f = 0.0F)
    {
      this.FKq = f;
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.FKq);
      AppMethodBeat.o(197547);
      return 0;
    }
    if (f == 0.0F) {
      this.FKq = 0.0F;
    }
    for (;;)
    {
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.FKq);
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(197547);
      return paramInt;
      if (this.FKq * f < 0.0F)
      {
        localRecyclerView = this.FKp;
        if (localRecyclerView != null) {
          localRecyclerView.setTranslationY(0.0F);
        }
        this.FKq = f;
      }
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(197548);
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(197548);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */