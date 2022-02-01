package com.tencent.mm.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
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
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "updateTimeRecord", "", "set", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "setExposeTimeRecordListener", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Landroidx/recyclerview/widget/RecyclerView;", "listener", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "canStartExpose", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "libmmui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final <T extends a> void a(RecyclerView paramRecyclerView, d<T> paramd, final kotlin.g.a.b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(234941);
    s.u(paramRecyclerView, "<this>");
    s.u(paramb, "canStartExpose");
    f.a(paramRecyclerView, (e.a)new b(paramd, paramb));
    f.a((View)paramRecyclerView, (e.b)new c(paramRecyclerView));
    AppMethodBeat.o(234941);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$2", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedRecordsAll", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "getExposedRecordsAll", "()Ljava/util/Set;", "setExposedRecordsAll", "(Ljava/util/Set;)V", "canStartExpose", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getExposedId", "", "ignoreFlingExposed", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.a
  {
    private Set<b<T>> agNM;
    
    b(d<T> paramd, kotlin.g.a.b<? super View, Boolean> paramb)
    {
      AppMethodBeat.i(234978);
      this.agNM = ((Set)new HashSet());
      AppMethodBeat.o(234978);
    }
    
    public final long aa(RecyclerView.v paramv)
    {
      AppMethodBeat.i(234989);
      if (this.agNN == null)
      {
        l = super.aa(paramv);
        AppMethodBeat.o(234989);
        return l;
      }
      if ((paramv instanceof j))
      {
        paramv = (j)paramv;
        if (paramv != null) {
          break label66;
        }
        paramv = null;
        label43:
        if (!(paramv instanceof a)) {
          break label77;
        }
      }
      for (;;)
      {
        if (paramv != null) {
          break label82;
        }
        AppMethodBeat.o(234989);
        return 0L;
        paramv = null;
        break;
        label66:
        paramv = (a)paramv.CSA;
        break label43;
        label77:
        paramv = null;
      }
      label82:
      long l = paramv.bZA();
      AppMethodBeat.o(234989);
      return l;
    }
    
    public final boolean ab(RecyclerView.v paramv)
    {
      AppMethodBeat.i(234992);
      kotlin.g.a.b localb = paramb;
      s.checkNotNull(paramv);
      paramv = paramv.caK;
      s.s(paramv, "holder!!.itemView");
      boolean bool = ((Boolean)localb.invoke(paramv)).booleanValue();
      AppMethodBeat.o(234992);
      return bool;
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(234986);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      if (paramList.isEmpty())
      {
        Log.i("MicroMsg.ExposeTimeRecordListener", "current exposed exposeHolders is empty");
        c.K(this.agNM);
        paramView = this.agNN;
        if (paramView != null) {
          paramView.s(this.agNM);
        }
        this.agNM.clear();
        AppMethodBeat.o(234986);
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
        if ((localObject2 instanceof j)) {
          paramList.add(localObject2);
        }
      }
      localObject1 = (Iterable)paramList;
      paramList = this.agNN;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (j)((Iterator)localObject1).next();
        Object localObject3 = ((j)localObject2).CSA;
        s.s(localObject3, "holder.getAssociatedObject()");
        localObject3 = new b((a)localObject3);
        if (!this.agNM.contains(localObject3))
        {
          ((b)localObject3).startTime = cn.bDw();
          ((b)localObject3).afqR = ((j)localObject2).KJ();
          ((b)localObject3).view = ((j)localObject2).caK;
          this.agNM.add(localObject3);
          Log.i("MicroMsg.ExposeTimeRecordListener", s.X("add new record: ", localObject3));
          if (paramList != null) {
            paramList.a((b)localObject3);
          }
        }
        paramView.add(localObject3);
      }
      if (this.agNM.size() > paramView.size())
      {
        paramView = ar.a(this.agNM, (Iterable)paramView);
        Log.i("MicroMsg.ExposeTimeRecordListener", s.X("find diff record: size = ", Integer.valueOf(paramView.size())));
        c.K(paramView);
        paramList = this.agNN;
        if (paramList != null) {
          paramList.s(paramView);
        }
        paramView = ar.a(this.agNM, (Iterable)paramView);
        if (!an.hF(paramView)) {
          break label399;
        }
      }
      for (;;)
      {
        if (paramView != null)
        {
          s.u(paramView, "<set-?>");
          this.agNM = paramView;
        }
        AppMethodBeat.o(234986);
        return;
        label399:
        paramView = null;
      }
    }
    
    public final boolean dXG()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/recyclerview/ExposeTimeRecordHelperKt$setExposeTimeRecordListener$3", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e.b
  {
    c(RecyclerView paramRecyclerView) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(234967);
      s.u(paramView, "view");
      AppMethodBeat.o(234967);
    }
    
    public final long fq(View paramView)
    {
      AppMethodBeat.i(234974);
      s.u(paramView, "view");
      long l = this.agNP.hashCode();
      AppMethodBeat.o(234974);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */