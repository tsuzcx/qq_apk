package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "updateTimeRecord", "", "set", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "setExposeTimeRecordListener", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Landroid/support/v7/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "libmmui_release"})
public final class c
{
  public static final <T extends a> void a(RecyclerView paramRecyclerView, d<T> paramd)
  {
    AppMethodBeat.i(205039);
    p.h(paramRecyclerView, "$this$setExposeTimeRecordListener");
    f.a(paramRecyclerView, (e.a)new a(paramd));
    f.a((View)paramRecyclerView, (e.b)new b(paramRecyclerView));
    AppMethodBeat.o(205039);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedRecordsAll", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "getExposedRecordsAll", "()Ljava/util/Set;", "setExposedRecordsAll", "(Ljava/util/Set;)V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
  public static final class a
    extends e.a
  {
    private Set<b<T>> RqB;
    
    a(d paramd)
    {
      AppMethodBeat.i(205036);
      this.RqB = ((Set)new HashSet());
      AppMethodBeat.o(205036);
    }
    
    public final long ae(RecyclerView.v paramv)
    {
      Object localObject = null;
      AppMethodBeat.i(205035);
      if (this.RqC != null)
      {
        if ((paramv instanceof h)) {
          break label97;
        }
        paramv = null;
      }
      label94:
      label97:
      for (;;)
      {
        paramv = (h)paramv;
        if (paramv != null)
        {
          paramv = (a)paramv.hgv();
          if ((paramv instanceof a)) {
            break label94;
          }
          paramv = localObject;
        }
        for (;;)
        {
          if (paramv != null)
          {
            l = paramv.lT();
            AppMethodBeat.o(205035);
            return l;
            paramv = null;
            break;
          }
          AppMethodBeat.o(205035);
          return 0L;
          long l = super.ae(paramv);
          AppMethodBeat.o(205035);
          return l;
        }
      }
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(205034);
      p.h(paramView, "parent");
      p.h(paramList, "exposedHolders");
      if (paramList.isEmpty())
      {
        Log.i("MicroMsg.ExposeTimeRecordListener", "current exposed exposeHolders is empty");
        c.y(this.RqB);
        paramView = this.RqC;
        if (paramView != null) {
          paramView.l(this.RqB);
        }
        this.RqB.clear();
        AppMethodBeat.o(205034);
        return;
      }
      paramView = new HashSet();
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof h)) {
          paramList.add(localObject2);
        }
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (h)paramList.next();
        localObject2 = ((h)localObject1).hgv();
        p.g(localObject2, "holder.getAssociatedObject()");
        localObject2 = new b((a)localObject2);
        if (!this.RqB.contains(localObject2))
        {
          ((b)localObject2).startTime = cl.aWA();
          ((b)localObject2).Qgj = ((h)localObject1).lR();
          this.RqB.add(localObject2);
          Log.i("MicroMsg.ExposeTimeRecordListener", "add new record: ".concat(String.valueOf(localObject2)));
          localObject1 = this.RqC;
          if (localObject1 != null) {
            ((d)localObject1).a((b)localObject2);
          }
        }
        paramView.add(localObject2);
      }
      if (this.RqB.size() > paramView.size())
      {
        paramView = ak.a(this.RqB, (Iterable)paramView);
        Log.i("MicroMsg.ExposeTimeRecordListener", "find diff record: size = " + paramView.size());
        c.y(paramView);
        paramList = this.RqC;
        if (paramList != null) {
          paramList.l(paramView);
        }
        paramList = ak.a(this.RqB, (Iterable)paramView);
        paramView = paramList;
        if (!af.fa(paramList)) {
          paramView = null;
        }
        if (paramView != null)
        {
          this.RqB = paramView;
          AppMethodBeat.o(205034);
          return;
        }
      }
      AppMethodBeat.o(205034);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
  public static final class b
    extends e.b
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final long hE(View paramView)
    {
      AppMethodBeat.i(205038);
      p.h(paramView, "view");
      long l = this.RqD.hashCode();
      AppMethodBeat.o(205038);
      return l;
    }
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(205037);
      p.h(paramView, "view");
      AppMethodBeat.o(205037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */