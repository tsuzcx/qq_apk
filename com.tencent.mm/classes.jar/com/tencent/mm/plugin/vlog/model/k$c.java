package com.tencent.mm.plugin.vlog.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import d.a.j;
import d.d.b.a.e;
import d.d.b.a.i;
import d.d.d;
import d.d.f;
import d.g.a.m;
import d.l;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.g;

@e(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f="MultiMediaModel.kt", l={69}, m="invokeSuspend")
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
public final class k$c
  extends i
  implements m<ag, d<? super Boolean>, Object>
{
  int label;
  Object nIC;
  private ag nvs;
  Object nvt;
  
  public k$c(k paramk, List paramList1, List paramList2, List paramList3, d paramd)
  {
    super(paramd);
  }
  
  public final d<y> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(207521);
    d.g.b.k.h(paramd, "completion");
    paramd = new c(this.Anx, this.Anz, this.AnA, this.AnB, paramd);
    paramd.nvs = ((ag)paramObject);
    AppMethodBeat.o(207521);
    return paramd;
  }
  
  public final Object cO(Object paramObject)
  {
    AppMethodBeat.i(207520);
    d.d.a.a locala = d.d.a.a.KUd;
    boolean bool;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(207520);
      throw paramObject;
    case 0: 
      paramObject = this.nvs;
      this.Anx.And.clear();
      this.Anx.qUF.clear();
      this.Anx.Ane.clear();
      this.Anx.Anf.clear();
      this.Anx.And.addAll((Collection)this.Anz);
      this.Anx.qUF.addAll((Collection)this.AnA);
      localObject1 = this.Anx.Ane;
      Object localObject2 = n.AnJ;
      Object localObject3 = this.Anz;
      localObject2 = this.AnA;
      List localList = this.AnB;
      d.g.b.k.h(localObject3, "paths");
      d.g.b.k.h(localObject2, "types");
      d.g.b.k.h(localList, "sourceFrom");
      LinkedList localLinkedList = new LinkedList();
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        int j = i + 1;
        if (i < 0) {
          j.fOc();
        }
        localObject4 = (String)localObject4;
        Object localObject5 = (Integer)j.C((List)localObject2, i);
        if (localObject5 == null) {}
        while (((Integer)localObject5).intValue() != 2)
        {
          localObject5 = n.AnJ;
          d.g.b.k.h(localObject4, "path");
          localObject5 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
          MMBitmapFactory.decodeFile((String)localObject4, (BitmapFactory.Options)localObject5);
          int n = n.a.ayh((String)localObject4);
          int m = ((BitmapFactory.Options)localObject5).outWidth;
          int k = ((BitmapFactory.Options)localObject5).outHeight;
          if ((n == 90) || (n == 270))
          {
            m = ((BitmapFactory.Options)localObject5).outHeight;
            k = ((BitmapFactory.Options)localObject5).outWidth;
          }
          localObject4 = new h(m, k, (String)localObject4);
          ((n)localObject4).AnI = ((Number)localList.get(i)).intValue();
          localLinkedList.add(localObject4);
          i = j;
          break;
        }
        localObject5 = n.AnJ;
        localObject4 = n.a.ayi((String)localObject4);
        if (localObject4 != null)
        {
          ((n)localObject4).AnI = ((Number)localList.get(i)).intValue();
          localLinkedList.add(localObject4);
          i = j;
        }
        else
        {
          i = j;
        }
      }
      ((LinkedList)localObject1).addAll((Collection)localLinkedList);
      localObject1 = this.Anx;
      localObject2 = (Iterable)this.Anx.Ane;
      if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!((n)((Iterator)localObject2).next() instanceof h))
          {
            bool = false;
            ((k)localObject1).Ang = bool;
            localObject1 = this.Anx;
            localObject2 = (Iterable)this.Anx.Ane;
            if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
              break label779;
            }
            localObject2 = ((Iterable)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (((n)((Iterator)localObject2).next() instanceof aa));
          }
        }
      }
      label779:
      for (bool = false;; bool = true)
      {
        ((k)localObject1).Anh = bool;
        localObject1 = this.Anx;
        localObject2 = com.tencent.mm.plugin.vlog.util.a.AvF;
        ((k)localObject1).Anm = com.tencent.mm.plugin.vlog.util.a.ic(((n)this.Anx.Ane.get(0)).width, ((n)this.Anx.Ane.get(0)).height);
        localObject1 = this.Anx.Anf;
        localObject2 = n.AnJ;
        localObject2 = (List)this.Anx.Ane;
        this.nvt = paramObject;
        this.nIC = localObject1;
        this.label = 1;
        paramObject = g.a((f)ay.gdP(), (m)new n.a.a((List)localObject2, null), this);
        if (paramObject != locala) {
          break label816;
        }
        AppMethodBeat.o(207520);
        return locala;
        bool = true;
        break;
      }
    }
    Object localObject1 = (LinkedList)this.nIC;
    label816:
    for (;;)
    {
      bool = ((LinkedList)localObject1).addAll((Collection)paramObject);
      AppMethodBeat.o(207520);
      return Boolean.valueOf(bool);
    }
  }
  
  public final Object n(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(207522);
    paramObject1 = ((c)a(paramObject1, (d)paramObject2)).cO(y.KTp);
    AppMethodBeat.o(207522);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k.c
 * JD-Core Version:    0.7.0.1
 */