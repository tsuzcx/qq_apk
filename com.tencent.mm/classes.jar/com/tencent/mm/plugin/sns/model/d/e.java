package com.tencent.mm.plugin.sns.model.d;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/WithTaRemove;", "", "()V", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a QAW;
  
  static
  {
    AppMethodBeat.i(309614);
    QAW = new a((byte)0);
    AppMethodBeat.o(309614);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/WithTaRemove$Companion;", "", "()V", "CANCEL", "", "REMOVE", "showAlertListDialog", "", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "seq", "", "action", "tipsId", "cb", "Lkotlin/Function1;", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(Context paramContext, aq paramaq, String paramString, int paramInt1, int paramInt2, b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(309601);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramaq, "scope");
      kotlin.g.b.s.u(paramString, "seq");
      kotlin.g.b.s.u(paramb, "cb");
      LinkedList localLinkedList = new LinkedList();
      Object localObject = paramContext.getString(b.j.sns_withta_remove_me2);
      kotlin.g.b.s.s(localObject, "context.getString(R.string.sns_withta_remove_me2)");
      localLinkedList.add(new r(Integer.valueOf(1), localObject));
      localObject = new f(paramContext, 1, true);
      ((f)localObject).Vtg = new e.a..ExternalSyntheticLambda0(localLinkedList);
      ((f)localObject).h((CharSequence)paramContext.getString(paramInt2), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 12));
      ((f)localObject).GAC = new e.a..ExternalSyntheticLambda1(paramaq, paramString, paramInt1, paramb);
      ((f)localObject).dDn();
      AppMethodBeat.o(309601);
    }
    
    private static final void a(LinkedList paramLinkedList, com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(309605);
      kotlin.g.b.s.u(paramLinkedList, "$menuItems");
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        r localr = (r)paramLinkedList.next();
        params.c(((Number)localr.bsC).intValue(), (CharSequence)localr.bsD);
      }
      AppMethodBeat.o(309605);
    }
    
    private static final void a(aq paramaq, String paramString, final int paramInt1, final b paramb, MenuItem paramMenuItem, int paramInt2)
    {
      AppMethodBeat.i(309612);
      kotlin.g.b.s.u(paramaq, "$scope");
      kotlin.g.b.s.u(paramString, "$seq");
      kotlin.g.b.s.u(paramb, "$cb");
      if (paramMenuItem.getItemId() == 1) {
        j.a(paramaq, null, null, (m)new a(paramString, paramInt1, paramb, null), 3);
      }
      AppMethodBeat.o(309612);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(String paramString, int paramInt, b<? super Boolean, ah> paramb, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(309613);
        paramObject = (kotlin.d.d)new a(this.QAX, paramInt1, paramb, paramd);
        AppMethodBeat.o(309613);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(309608);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(309608);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = d.QAS;
          Object localObject = this.QAX;
          int i = paramInt1;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = paramObject.f((String)localObject, i, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(309608);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        boolean bool = ((Boolean)paramObject).booleanValue();
        paramObject = paramb;
        if (bool) {}
        for (bool = true;; bool = false)
        {
          paramObject.invoke(Boolean.valueOf(bool));
          paramObject = ah.aiuX;
          AppMethodBeat.o(309608);
          return paramObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.e
 * JD-Core Version:    0.7.0.1
 */