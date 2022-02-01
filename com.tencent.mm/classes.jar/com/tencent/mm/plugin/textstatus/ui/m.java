package com.tencent.mm.plugin.textstatus.ui;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusTopicSquareScrollUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lastOffset", "", "getLastOffset", "()I", "setLastOffset", "(I)V", "lastPosition", "getLastPosition", "()Ljava/lang/Integer;", "setLastPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "initScrollPos", "", "scrollPos", "initView", "onPause", "onResume", "tryScroll", "curPos", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
{
  public static final m.a TAt;
  int ESj;
  Integer TAu;
  RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(291285);
    TAt = new m.a((byte)0);
    AppMethodBeat.o(291285);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291265);
    AppMethodBeat.o(291265);
  }
  
  private static final boolean a(m paramm, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(291278);
    s.u(paramm, "this$0");
    if (paramm.TAu != null) {
      paramm.TAu = null;
    }
    AppMethodBeat.o(291278);
    return false;
  }
  
  public final void K(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(291300);
    s.u(paramRecyclerView, "recyclerView");
    this.mkw = paramRecyclerView;
    paramRecyclerView.setOnTouchListener(new m..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(291300);
  }
  
  public final void hKc()
  {
    AppMethodBeat.i(291330);
    Object localObject1 = this.TAu;
    if (localObject1 != null)
    {
      int i = ((Number)localObject1).intValue();
      new StringBuilder("tryScroll() called pos:").append(this.TAu).append(" offset:").append(this.ESj);
      try
      {
        localObject1 = this.mkw;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label105;
          }
        }
        label105:
        for (localObject1 = (LinearLayoutManager)localObject1;; localObject1 = null)
        {
          if (localObject1 != null)
          {
            ((LinearLayoutManager)localObject1).bo(i, this.ESj);
            localObject1 = ah.aiuX;
          }
          AppMethodBeat.o(291330);
          return;
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
          break;
        }
        ah localah;
        AppMethodBeat.o(291330);
      }
      finally
      {
        localah = ah.aiuX;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291309);
    super.onPause();
    Object localObject = this.mkw;
    label32:
    int j;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof LinearLayoutManager)) {
        break label103;
      }
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null)
      {
        j = ((LinearLayoutManager)localObject).Ju();
        localObject = ((LinearLayoutManager)localObject).findViewByPosition(j);
        if (localObject != null) {
          break label108;
        }
      }
    }
    label103:
    label108:
    for (int i = 0;; i = ((View)localObject).getTop())
    {
      new StringBuilder("onPause() called pos:").append(j).append(" offset:").append(i);
      this.TAu = Integer.valueOf(j);
      this.ESj = i;
      AppMethodBeat.o(291309);
      return;
      localObject = ((RecyclerView)localObject).getLayoutManager();
      break;
      localObject = null;
      break label32;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291321);
    super.onResume();
    new StringBuilder("onResume() called pos:").append(this.TAu).append(" offset:").append(this.ESj);
    AppMethodBeat.o(291321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.m
 * JD-Core Version:    0.7.0.1
 */