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
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "mMultiTaskRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mPreTransY", "", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setMultiTaskRecyclerView", "recyclerView", "smoothScrollToPosition", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MinusScreenGridLayoutManager
  extends GridLayoutManager
{
  public static final MinusScreenGridLayoutManager.a LFE;
  public RecyclerView LFF;
  private float LFG;
  
  static
  {
    AppMethodBeat.i(304494);
    LFE = new MinusScreenGridLayoutManager.a((byte)0);
    AppMethodBeat.o(304494);
  }
  
  public MinusScreenGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
  }
  
  public final void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304523);
    super.bo(paramInt1, paramInt2);
    AppMethodBeat.o(304523);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(304502);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(304502);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(304502);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(304531);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("Kl", new Class[0]);
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        Log.i("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(304531);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(304531);
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(304517);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(304517);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 0;
    AppMethodBeat.i(304508);
    RecyclerView localRecyclerView = this.LFF;
    float f;
    if (localRecyclerView == null)
    {
      f = 0.0F;
      if (f != 0.0F) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (this.LFG * f < 0.0F)) {
        break label112;
      }
      this.LFG = f;
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.LFG);
      AppMethodBeat.o(304508);
      return 0;
      f = localRecyclerView.getTranslationY();
      break;
    }
    label112:
    i = j;
    if (f == 0.0F) {
      i = 1;
    }
    if (i != 0) {
      this.LFG = 0.0F;
    }
    for (;;)
    {
      Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + f + ", preTransY: " + this.LFG);
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(304508);
      return paramInt;
      if (this.LFG * f < 0.0F)
      {
        localRecyclerView = this.LFF;
        if (localRecyclerView != null) {
          localRecyclerView.setTranslationY(0.0F);
        }
        this.LFG = f;
      }
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(304512);
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(304512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */