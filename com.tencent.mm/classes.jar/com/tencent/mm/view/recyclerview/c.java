package com.tencent.mm.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
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
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "updateTimeRecord", "", "set", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "setExposeTimeRecordListener", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "libmmui_release"})
public final class c
{
  public static final <T extends a> void a(RecyclerView paramRecyclerView, d<T> paramd)
  {
    AppMethodBeat.i(223684);
    p.k(paramRecyclerView, "$this$setExposeTimeRecordListener");
    f.a(paramRecyclerView, (e.a)new a(paramd));
    f.a((View)paramRecyclerView, (e.b)new b(paramRecyclerView));
    AppMethodBeat.o(223684);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedRecordsAll", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "getExposedRecordsAll", "()Ljava/util/Set;", "setExposedRecordsAll", "(Ljava/util/Set;)V", "getExposedId", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
  public static final class a
    extends e.a
  {
    private Set<b<T>> YRZ;
    
    a(d paramd)
    {
      AppMethodBeat.i(190736);
      this.YRZ = ((Set)new HashSet());
      AppMethodBeat.o(190736);
    }
    
    public final long af(RecyclerView.v paramv)
    {
      Object localObject = null;
      AppMethodBeat.i(190734);
      if (this.YSa != null)
      {
        if ((paramv instanceof i)) {
          break label97;
        }
        paramv = null;
      }
      label94:
      label97:
      for (;;)
      {
        paramv = (i)paramv;
        if (paramv != null)
        {
          paramv = (a)paramv.ihX();
          if ((paramv instanceof a)) {
            break label94;
          }
          paramv = localObject;
        }
        for (;;)
        {
          if (paramv != null)
          {
            l = paramv.mf();
            AppMethodBeat.o(190734);
            return l;
            paramv = null;
            break;
          }
          AppMethodBeat.o(190734);
          return 0L;
          long l = super.af(paramv);
          AppMethodBeat.o(190734);
          return l;
        }
      }
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(190726);
      p.k(paramView, "parent");
      p.k(paramList, "exposedHolders");
      if (paramList.isEmpty())
      {
        Log.i("MicroMsg.ExposeTimeRecordListener", "current exposed exposeHolders is empty");
        c.y(this.YRZ);
        paramView = this.YSa;
        if (paramView != null) {
          paramView.l(this.YRZ);
        }
        this.YRZ.clear();
        AppMethodBeat.o(190726);
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
        if ((localObject2 instanceof i)) {
          paramList.add(localObject2);
        }
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (i)paramList.next();
        localObject2 = ((i)localObject1).ihX();
        p.j(localObject2, "holder.getAssociatedObject()");
        localObject2 = new b((a)localObject2);
        if (!this.YRZ.contains(localObject2))
        {
          ((b)localObject2).startTime = cm.bfE();
          ((b)localObject2).XDo = ((i)localObject1).md();
          this.YRZ.add(localObject2);
          Log.i("MicroMsg.ExposeTimeRecordListener", "add new record: ".concat(String.valueOf(localObject2)));
          localObject1 = this.YSa;
          if (localObject1 != null) {
            ((d)localObject1).a((b)localObject2);
          }
        }
        paramView.add(localObject2);
      }
      if (this.YRZ.size() > paramView.size())
      {
        paramView = ak.a(this.YRZ, (Iterable)paramView);
        Log.i("MicroMsg.ExposeTimeRecordListener", "find diff record: size = " + paramView.size());
        c.y(paramView);
        paramList = this.YSa;
        if (paramList != null) {
          paramList.l(paramView);
        }
        paramList = ak.a(this.YRZ, (Iterable)paramView);
        paramView = paramList;
        if (!ag.fh(paramList)) {
          paramView = null;
        }
        if (paramView != null)
        {
          this.YRZ = paramView;
          AppMethodBeat.o(190726);
          return;
        }
      }
      AppMethodBeat.o(190726);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
  public static final class b
    extends e.b
  {
    b(RecyclerView paramRecyclerView) {}
    
    public final long er(View paramView)
    {
      AppMethodBeat.i(216200);
      p.k(paramView, "view");
      long l = this.YSb.hashCode();
      AppMethodBeat.o(216200);
      return l;
    }
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(216198);
      p.k(paramView, "view");
      AppMethodBeat.o(216198);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */