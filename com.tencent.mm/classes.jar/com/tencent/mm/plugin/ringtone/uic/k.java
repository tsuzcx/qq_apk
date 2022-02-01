package com.tencent.mm.plugin.ringtone.uic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.f.c;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.n;
import com.tencent.mm.protocal.protobuf.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSelectDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_maxSeq", "", "hashContinue", "", "recommendJob", "Lkotlinx/coroutines/Job;", "ringtoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRecommendRingBackInfo;", "Lkotlin/collections/ArrayList;", "getRingtoneItems", "()Ljava/util/ArrayList;", "setRingtoneItems", "(Ljava/util/ArrayList;)V", "loadMore", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
{
  public static final k.a OFB;
  private int OFC;
  ArrayList<n> OFr;
  private cb OFs;
  private boolean OFt;
  
  static
  {
    AppMethodBeat.i(273329);
    OFB = new k.a((byte)0);
    AppMethodBeat.o(273329);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273309);
    this.OFr = new ArrayList();
    this.OFt = true;
    this.OFC = -1;
    AppMethodBeat.o(273309);
  }
  
  public final void aWi()
  {
    int i = 1;
    AppMethodBeat.i(273361);
    if (!this.OFt)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((a)com.tencent.mm.ui.component.k.d(getActivity()).q(a.class)).gOO();
      AppMethodBeat.o(273361);
      return;
    }
    Object localObject = this.OFs;
    if ((localObject != null) && (((cb)localObject).isActive() == true)) {}
    for (;;)
    {
      if (i == 0) {
        this.OFs = j.a(getLifecycleScope(), null, null, (kotlin.g.a.m)new b(this, null), 3);
      }
      AppMethodBeat.o(273361);
      return;
      i = 0;
    }
  }
  
  public final void bs(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(273337);
    s.u(paramArrayList, "<set-?>");
    this.OFr = paramArrayList;
    AppMethodBeat.o(273337);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273347);
    super.onCreateAfter(paramBundle);
    aWi();
    AppMethodBeat.o(273347);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273372);
    super.onDestroy();
    cb localcb = this.OFs;
    if (localcb != null) {
      localcb.a(null);
    }
    this.OFr.clear();
    AppMethodBeat.o(273372);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(k paramk, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273303);
      paramObject = (d)new b(this.OFD, paramd);
      AppMethodBeat.o(273303);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273298);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273298);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        try
        {
          paramObject = com.tencent.mm.ui.component.k.aeZF;
          long l = ((m)com.tencent.mm.ui.component.k.d(this.OFD.getActivity()).q(m.class)).OFI;
          paramObject = (com.tencent.mm.am.b)new c(k.a(this.OFD) + 1, String.valueOf(l));
          localObject1 = (d)this;
          this.label = 1;
          paramObject = com.tencent.mm.af.b.a(paramObject, (d)localObject1);
          localObject1 = paramObject;
          if (paramObject == localObject2)
          {
            AppMethodBeat.o(273298);
            return localObject2;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
          }
          localObject1 = (p)localObject1;
          k.a(this.OFD, ((p)localObject1).aavs);
          paramObject = new ArrayList();
          if (k.a(this.OFD) == -1) {
            break label533;
          }
          i = 0;
          localObject1 = ((p)localObject1).acja;
          s.s(localObject1, "resp.Infos");
          localObject2 = (Iterable)localObject1;
          localObject1 = this.OFD;
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (n)((Iterator)localObject2).next();
            if ((k.a((k)localObject1) == -1) || (k.a((k)localObject1) < ((n)localObject3).YYs)) {
              k.a((k)localObject1, ((n)localObject3).YYs);
            }
            paramObject.add(localObject3);
            localObject3 = com.tencent.mm.ui.component.k.aeZF;
            ((m)com.tencent.mm.ui.component.k.d(((k)localObject1).getActivity()).q(m.class)).cy();
            continue;
          }
          this.OFD.bs(paramObject);
        }
        catch (Exception paramObject)
        {
          Log.e("MicroMsg.RingtoneSearchDataUIC", s.X("GetRecommendRingBack failed: ", paramObject.getMessage()));
          k.a(this.OFD, false);
          this.OFD.bs(new ArrayList());
          paramObject = com.tencent.mm.ui.component.k.aeZF;
          ((a)com.tencent.mm.ui.component.k.d(this.OFD.getActivity()).q(a.class)).gOO();
          paramObject = ah.aiuX;
          AppMethodBeat.o(273298);
          return paramObject;
        }
        if (i != 0)
        {
          paramObject = com.tencent.mm.ui.component.k.aeZF;
          ((a)com.tencent.mm.ui.component.k.d(this.OFD.getActivity()).q(a.class)).gOw();
        }
        paramObject = new ArrayList();
        Object localObject1 = ((Iterable)this.OFD.OFr).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((n)((Iterator)localObject1).next()).aciQ;
          if (localObject2 != null) {
            paramObject.add(new e((aa)localObject2));
          }
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((a)com.tencent.mm.ui.component.k.d(this.OFD.getActivity()).q(a.class)).bq(paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(273298);
        return paramObject;
        label533:
        int i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.k
 * JD-Core Version:    0.7.0.1
 */